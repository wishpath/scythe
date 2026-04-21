package org.sa;

import org.sa.DTO.ActionSpaceDTO;
import org.sa.DTO.PlayerDTO;
import org.sa.DTO.TileDTO;
import org.sa.DTO.placeable.movable.Movable;
import org.sa.DTO.placeable.movable.WorkerDTO;
import org.sa.b_storage.CardPool;
import org.sa.b_storage.Grid;
import org.sa.enums.*;
import org.sa.reward.upgradable_state_change_top.UpgradableStateChange_Top;
import org.sa.reward.upgradable_state_change_top.UpgradableStateChange_Top_Move;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class PlayerDecisions {

  public static void main(String[] args) {
    //player draws Faction Mat (color)
    FactionMat factionMat = CardPool.drawEnlistCard();

    //player draws Player Mat (not connected to faction)
    PlayerMat playerMat = CardPool.drawFactionBoard();

    //player chooses where to place workers
    List<WorkerDTO> workers = new ArrayList<>(factionMat.initialWorkersCount);
    for (int i = 0; i < factionMat.initialWorkersCount; i++) {
      Set<TileDTO> nearHomeTiles = Grid.getNonNullNeighborsNotSelf(factionMat.home);
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
    ActionSpaceDTO[] actionSpaces = playerMat.initialActionSpaces; //TODO: action spaces should come from playerMat STATE


    //player picks MOVE_GAIN
    ActionTop pickedActionSpaceType = ActionTop.MOVE_GAIN; //TODO: player should pick
    ActionSpaceDTO pickedActionSpaceDTO__MOVE_GAIN = null;
    for (ActionSpaceDTO actionSpace : actionSpaces)
      if (actionSpace.actionTop == pickedActionSpaceType) {
        pickedActionSpaceDTO__MOVE_GAIN = actionSpace;
        break;
      }

    //player decides to actually use MOVE_GAIN and pays for it
    boolean playerDecidedToUseTopAction = true; //TODO: player should decide
    if (playerDecidedToUseTopAction) {
      pickedActionSpaceDTO__MOVE_GAIN.actionTopCost.applyToPlayer(player);


      //player picks MOVE from MOVE_GAIN
      int picked_reward_index__representing_MOVE = 0; //TODO: player should pick (0 for move and 1 for gain coins)
      UpgradableStateChange_Top pickedReward_MOVE = pickedActionSpaceDTO__MOVE_GAIN.actionTop_Rewards_toChoose_upgradable[picked_reward_index__representing_MOVE];

      //player decides what and where to MOVE
      applyTopAction(pickedReward_MOVE, player); //so each decision in the list is a separate movable group and target

    }
  }

  private static void applyTopAction(UpgradableStateChange_Top pickedReward_MOVE, PlayerDTO player) {

    //case when decision is not needed, simply apply
    if (pickedReward_MOVE.getDecisionType() == TopStateChangeDecision_TYPE_ENUM.NONE)
      pickedReward_MOVE.applyToPlayer(player);

    //cases with decision (top reward)
    switch (pickedReward_MOVE.getDecisionType()) {
      case TopStateChangeDecision_TYPE_ENUM.MOVE -> DECIDE_andApply_TopAction_MOVE((UpgradableStateChange_Top_Move) pickedReward_MOVE, player); //cast to MOVE class
      case TopStateChangeDecision_TYPE_ENUM.PRODUCE -> {} //TODO: create
      case TopStateChangeDecision_TYPE_ENUM.TRADE -> {} //TODO: create
      default -> throw new IllegalStateException("UNEXPECTED DECISION TYPE: " + pickedReward_MOVE.getDecisionType());
    };
  }

  private static void DECIDE_andApply_TopAction_MOVE(UpgradableStateChange_Top_Move pickedReward_MOVE, PlayerDTO player) {
    int rewardDelta__MOVE_GROUP_COUNT = pickedReward_MOVE.getCurrentChangeDelta();
    List<Movable> movablesPool = new ArrayList<>(player.movables); // new list but references same objects

    for (int i = 0; i < rewardDelta__MOVE_GROUP_COUNT && movablesPool.size() > 0; i++) {

      //decide who move
      int userPicked_mainMovableIndex = new Random().nextInt(movablesPool.size()); // todo:  PLAYER should DECIDE main movable
      Movable userPicked_mainMovable = movablesPool.remove(userPicked_mainMovableIndex);
      List<Movable> groupOfMovablesDecidedToMove = new ArrayList<>(List.of(userPicked_mainMovable));
      if (userPicked_mainMovable.getMovableType() == MovableType.MECH && player.canMechBringWorkers) {
        //TODO: pick workers to carry together and append to movablesGroup -
        // todo:  PLAYER DECIDES
      }

      //decide where to move
      Set<TileDTO> possibleTargets = Grid.getTilesToMoveTo(userPicked_mainMovable, player); //TODO: get list of available Tiles to go to and PLAYER SHOULD PICK ONE
      if (possibleTargets.size() == 0) {
        //main movable has nowhere to go
        i--; // let's not count this as a move
        //lets return them to the pool, but only if they have chance to be moved
        for (Movable movable : groupOfMovablesDecidedToMove)
          if (hasChanceToBeMoved(movable)) //careful to not produce infinite loops
            movablesPool.add(movable);
        continue;
      }
      TileDTO targetTile = possibleTargets.iterator().next(); //TODO: player picks target tile

      //execute move
      for (Movable movable : groupOfMovablesDecidedToMove) movable.moveTo(targetTile, player); //execute move
    }
  }

  private static boolean hasChanceToBeMoved(Movable movable) {
    return true; //TODO: implement
  }
}