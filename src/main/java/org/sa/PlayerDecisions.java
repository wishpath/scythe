package org.sa;

import org.sa.DTO.ActionSpaceDTO;
import org.sa.DTO.PlayerDTO;
import org.sa.DTO.TileDTO;
import org.sa.DTO.placeable.movable.Movable;
import org.sa.DTO.placeable.movable.WorkerDTO;
import org.sa.DTO.top_state_change_decision.MoveDecision;
import org.sa.DTO.top_state_change_decision.TopStateChangeDecision;
import org.sa.b_storage.Grid;
import org.sa.b_storage.CardPool;
import org.sa.enums.*;
import org.sa.reward.StateChange;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    ActionTop pickedActionSpaceType = ActionTop.MOVE_GAIN; //TODO: player should pick
    ActionSpaceDTO pickedActionSpaceDTO__MOVE_GAIN = null;
    for (ActionSpaceDTO actionSpace : actionSpaces)
      if (actionSpace.actionTop == pickedActionSpaceType) {
        pickedActionSpaceDTO__MOVE_GAIN = actionSpace;
        break;
      }
    boolean playerDecidedToUseTopAction = true; //TODO: player should decide
    if (playerDecidedToUseTopAction) {
      pickedActionSpaceDTO__MOVE_GAIN.actionTopCost.applyToPlayer(player);
      int picked_reward_index__representing_MOVE = 0; //TODO: player should pick (0 for move and 1 for gain coins)
      StateChange pickedReward_MOVE = pickedActionSpaceDTO__MOVE_GAIN.actionTop_Rewards_toChoose_upgradable[picked_reward_index__representing_MOVE];
      //MOVE Reward move should have field requiredDecisionType so we can call method decide(requiredDecisionType)
      //TODO:
      // should get number of movable groups
      int numberOfMovables = pickedReward_MOVE.getCurrentChangeDelta();
      List<Movable> movables = player.movables; //TODO: group them
      //TODO: should pick and group from "movables"
      // for each:
        //TODO: should get availabe tiles to move to
        // decide if MOVE or skip this move.
        // should pick concrete tiles to move to
        // should send Movable group and locations to move to Reward
        // applyToPlayer would actually apply location directly to Movable group (not player as usual)
        // decide Maybe "Change" interface would be useful, since move is not classic "Reward"
    }
  }

  private List<TopStateChangeDecision> decide(TopStateChangeDecisionType type, PlayerDTO player, int capacity) {
    return switch (type) {
      case TopStateChangeDecisionType.MOVE -> decideMove(player, capacity);
      case TopStateChangeDecisionType.PRODUCE -> null; //TODO: create
      case TopStateChangeDecisionType.TRADE -> null; //TODO: create
      case TopStateChangeDecisionType.NONE -> null;
    };
  }

  private List<TopStateChangeDecision> decideMove(PlayerDTO player, int capacity) {
    //TODO: implement
    Set<Integer> pickedMovableIndexes = new HashSet<>();
    List<MoveDecision.GroupAndTarget> groups = new ArrayList<>();

    for (int i = 0; i < capacity && pickedMovableIndexes.size() < player.movables.size(); i++) {

      int userPickedIndexOfMovables = hereUserShouldPickAFreeMovable(player.movables, pickedMovableIndexes); //TODO: user should pick
      pickedMovableIndexes.add(userPickedIndexOfMovables);
      Movable pickedMovable = player.movables.get(userPickedIndexOfMovables);
      List<Movable> movableGroup = new ArrayList<>();
      movableGroup.add(pickedMovable);
      if (pickedMovable.getMovableType() == MovableType.MECH) {
        //TODO: pick workers to carry together
      }
      //TODO: get list of available Tiles to go to




      //MoveDecision.Group group = new MoveDecision.Group()
      //pick Movable index
      //if Movable is Robot and ability is there: decide which workers to take together
      //formulate this Group
      //Add groups to MoveDecision
      //If players.movables are finished - break
    }

    return new MoveDecision(groups);
  }

  private static int hereUserShouldPickAFreeMovable(List<Movable> movables, Set<Integer> pickedMovableIndexes) {
    int index = new java.util.Random().nextInt(movables.size());
    while (pickedMovableIndexes.contains(index)) new java.util.Random().nextInt(movables.size());
    return index;
  }
}