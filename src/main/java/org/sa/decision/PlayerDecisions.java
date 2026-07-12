package org.sa.decision;

import org.sa.DTO.PlayerDTO;
import org.sa.DTO.TileDTO;
import org.sa.DTO.placeable.TokenDTO;
import org.sa.DTO.placeable.movable.Movable;
import org.sa.DTO.placeable.movable.WorkerDTO;
import org.sa.b_storage.CardPool;
import org.sa.b_storage.Grid;
import org.sa.decision.helper.NotMovedHandler;
import org.sa.enums.FactionMat;
import org.sa.player_mat.ActionSpaceDTO;
import org.sa.player_mat.PlayerMatDTO;
import org.sa.player_mat.a_top_parts.enums_and_interfaces.TYPE__TopPart__TopPartChooseActionArray__ActionSpace;
import org.sa.player_mat.a_top_parts.enums_and_interfaces.TopPartDecision_TYPE_ENUM;
import org.sa.player_mat.a_top_parts.top_part_upgradable_action.TopPartUpgradableAction_Move_Decideable;
import org.sa.player_mat.a_top_parts.top_part_upgradable_action.interfaces.TopPartUpgradableAction;
import org.sa.player_mat.a_top_parts.top_part_upgradable_action.interfaces.TopPartUpgradableAction_ConcreteDeltaType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class PlayerDecisions {

  public static void main(String[] args) {
    //player draws Faction Mat (color)
    FactionMat factionMat = CardPool.drawEnlistCard();

    //player draws Player Mat (not connected to faction)
    PlayerMatDTO playerMat = CardPool.drawPlayerMat();

    //player chooses where to place workers
    final int INITIAL_WORKERS_COUNT = 2;
    List<WorkerDTO> workers = new ArrayList<>(INITIAL_WORKERS_COUNT);
    for (int i = 0; i < INITIAL_WORKERS_COUNT; i++) {
      Set<TileDTO> nearHomeTiles = Grid.getNonNullNeighborsNotSelf(factionMat.homeTile);
      workers.add(new WorkerDTO(nearHomeTiles.iterator().next())); //TODO: player should pick for each
    }

    PlayerDTO player = new PlayerDTO(playerMat, factionMat, workers);

    //someone starts the game and there comes turn for the player
    player.isEndOfTurn = false;
    //TODO:
    // have field "previousActionSpace"
    // pick new "actionSpace"

    //TODO: write example of each action space and action


    /**EXAMPLE of MOVE ACTION*****************************************************************************************/
    ActionSpaceDTO[] actionSpaces = playerMat.actionSpaces_leftToRight; //TODO: action spaces should come from playerMat STATE


    //player picks MOVE_GAIN
    TYPE__TopPart__TopPartChooseActionArray__ActionSpace pickedActionSpaceType = TYPE__TopPart__TopPartChooseActionArray__ActionSpace.CHOOSE__MOVE__GAIN_COINS; //TODO: player should pick (should not be previous actionSpace(except rusviet)


    ActionSpaceDTO pickedActionSpaceDTO__MOVE_GAIN = null;
    for (ActionSpaceDTO actionSpace : actionSpaces)
      if (actionSpace.tYPE__TopPart__TopPartChooseActionArray__ActionSpace == pickedActionSpaceType) {
        pickedActionSpaceDTO__MOVE_GAIN = actionSpace;
        break;
      }

    //player decides to actually use (and not skip) MOVE_GAIN and pays for it
    boolean playerDecidedToUseTopAction = true; //TODO: player should decide
    if (playerDecidedToUseTopAction) {
      pickedActionSpaceDTO__MOVE_GAIN.topPartObject.getCost().applyToPlayer(player);


      //player picks MOVE from MOVE_GAIN
      int picked_reward_index__representing_MOVE = 0; //TODO: player should pick (0 for move and 1 for gain coins)
      TopPartUpgradableAction pickedReward_MOVE = pickedActionSpaceDTO__MOVE_GAIN.topPartObject.getTopPartChoosableActions()[picked_reward_index__representing_MOVE];

      //player decides what and where to MOVE
      applyTopAction(pickedReward_MOVE, player);
    }

    //Then player deals with bottom action
    //then turn finishes:
    player.isEndOfTurn = true;
    player.previousActionSpace = pickedActionSpaceType;
  }

  private static void applyTopAction(TopPartUpgradableAction pickedReward_MOVE, PlayerDTO player) {
    switch (pickedReward_MOVE.getDecisionType()) {
      case TopPartDecision_TYPE_ENUM.MOVE -> DECIDE_andApply_TopAction_MOVE((TopPartUpgradableAction_Move_Decideable) pickedReward_MOVE, player); //cast to MOVE class
      case TopPartDecision_TYPE_ENUM.PRODUCE -> {} //TODO: create
      case TopPartDecision_TYPE_ENUM.TRADE -> {} //TODO: create
      case TopPartDecision_TYPE_ENUM.NONE -> ((TopPartUpgradableAction_ConcreteDeltaType) pickedReward_MOVE).applyToPlayer(player); //case when decision is not needed, simply apply
      default -> throw new IllegalStateException("UNEXPECTED DECISION TYPE: " + pickedReward_MOVE.getDecisionType());
    };
  }

  private static void DECIDE_andApply_TopAction_MOVE(TopPartUpgradableAction_Move_Decideable moveStateChange, PlayerDTO player) {
    int moveCountTotal = moveStateChange.getCurrentChangeDelta();
    List<Movable> movablesPool = new ArrayList<>(player.movables); // new list but references same objects

    for (int moveCount = 0; moveCount < moveCountTotal && movablesPool.size() > 0; moveCount++) {
      //decide who moves
      int userPicked_mainMovableIndex = new Random().nextInt(movablesPool.size()); // todo: PLAYER DECIDES main movable
      Movable userPicked_mainMovable = movablesPool.remove(userPicked_mainMovableIndex);
      List<Movable> groupOfMovablesDecidedToMove = new ArrayList<>(List.of(userPicked_mainMovable)); //includes main movable
      if (userPicked_mainMovable.isMech()) { //mechs can always carry workers
        TileDTO mechLocation = userPicked_mainMovable.getLocation();
        List<Movable> workersInMechLocation = movablesPool.stream().filter(Movable::isWorker).filter(worker -> worker.getLocation() == mechLocation).toList(); //creates different list, but objects reference matching references
        int playerPicked_workersCountToMoveTogether = workersInMechLocation.size();//todo: PLAYER DECIDES how many workers go together
        for (int j = 0; j < playerPicked_workersCountToMoveTogether; j++) {
          Movable worker = workersInMechLocation.get(j);
          groupOfMovablesDecidedToMove.add(worker);
          movablesPool.remove(worker);
        }
      }

      //decide where to move
      Set<TileDTO> possibleTargets = Grid.getTilesToMoveTo(userPicked_mainMovable, player); //TODO: get list of available Tiles to go to and PLAYER SHOULD PICK ONE
      if (possibleTargets.size() == 0) { //main movable has nowhere to go
        NotMovedHandler.returnOrForgetMovables(player, groupOfMovablesDecidedToMove, userPicked_mainMovable, movablesPool);
        moveCount--; // not counting this iteration as move;
        continue; // no need/ impossible to pick targetTile and complete move
      }

      //move
      TileDTO targetTile = possibleTargets.iterator().next(); //TODO: player picks target tile
      for (Movable movable : groupOfMovablesDecidedToMove) movable.moveTo(targetTile, player); //execute move (considered as one move)

      //after move effects
      player.isRightAfterMove = true;
      if (player.GREEN_ALBION_flagTokenPool_exalt > 0 && player.isRightAfterMove && userPicked_mainMovable.isCharacter() && !player.hasTileAToken(targetTile)) {
        boolean decidedPlayerToPlaceToken = true; //TODO: player decides
        if (decidedPlayerToPlaceToken) {
          player.placed_tokens.add(new TokenDTO(player, userPicked_mainMovable));
          player.GREEN_ALBION_flagTokenPool_exalt--;
        }
      }
      player.isRightAfterMove = false;

      //fight
      //TODO: fight
    }

  }
}