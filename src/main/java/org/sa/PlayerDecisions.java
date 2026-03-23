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
import org.sa.enums.ActionTop;
import org.sa.enums.FactionMat_EnlistCard;
import org.sa.enums.PlayerMat;
import org.sa.enums.TopStateChangeDecisionType;
import org.sa.reward.Reward;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PlayerDecisions {

  public static void main(String[] args) {
    //player draws Faction Mat (color)
    FactionMat_EnlistCard factionMat = CardPool.drawEnlistCard();

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
    ActionSpaceDTO pickedActionSpaceDTO = null;
    for (ActionSpaceDTO actionSpace : actionSpaces)
      if (actionSpace.actionTop == pickedActionSpaceType) {
        pickedActionSpaceDTO = actionSpace;
        break;
      }
    boolean playerDecidedToUseTopAction = true; //TODO: player should decide
    if (playerDecidedToUseTopAction) {
      pickedActionSpaceDTO.actionTopCost.applyToPlayer(player);
      int picked_reward_index_move = 1; //TODO: player should pick
      Reward pickedReward = pickedActionSpaceDTO.actionTop_Rewards_toChoose_upgradable[picked_reward_index_move];
      //TODO:
      // should get number of movable groups
      //int numberOfMovables =
      List<Movable> movables = player.movables; //TODO: group them
      //TODO: should pick and group from "movables"
      // for each:
        //TODO: should get availabe tiles to move to
        // should pick concrete tiles to move to
        // should send Movable group and locations to move to Reward
        // applyToPlayer would actually apply location directly to Movable group (not player as usual)
        // decide Maybe "Change" interface would be useful, since move is not classic "Reward"
    }
  }

  private TopStateChangeDecision decide(TopStateChangeDecisionType type, PlayerDTO player, int capacity) {
    return switch (type) {
      case TopStateChangeDecisionType.MOVE -> decideMove(player, capacity);
      case TopStateChangeDecisionType.PRODUCE -> null; //TODO: create
      case TopStateChangeDecisionType.TRADE -> null; //TODO: create
      case TopStateChangeDecisionType.NONE -> null;
    };
  }

  private TopStateChangeDecision decideMove(PlayerDTO player, int capacity) {
    //TODO: implement
    List<MoveDecision.Group> groups = new ArrayList<>();

    for (int i = 0; i < capacity; i++) {
      //pick Movable
      //if Movable is Robot and ability is there: decide which workers to take together
      //formulate this Group
      //Add groups to MoveDecision
      //If players.movables are finished - break
    }

    return new MoveDecision(groups);
  }
}