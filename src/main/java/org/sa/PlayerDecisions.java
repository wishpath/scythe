package org.sa;

import org.sa.DTO.ActionSpaceDTO;
import org.sa.DTO.PlayerDTO;
import org.sa.DTO.TileDTO;
import org.sa.DTO.placeable.movable.Movable;
import org.sa.DTO.placeable.movable.WorkerDTO;
import org.sa.b_storage.Grid;
import org.sa.b_storage.CardPool;
import org.sa.enums.ActionTop;
import org.sa.enums.FactionMat_EnlistCard;
import org.sa.enums.PlayerMat;
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

    //TODO: lets say MOVE action_space is picked
    ActionSpaceDTO[] actionSpaces = playerMat.initialActionSpaces; //TODO: action spaces should come from playerMat STATE
    ActionTop pickedActionSpaceType = ActionTop.MOVE_GAIN; //TODO: player should pick
    ActionSpaceDTO actionSpaceDTO = null;
    for (ActionSpaceDTO actionSpace : actionSpaces)
      if (actionSpace.actionTop == pickedActionSpaceType) {
        actionSpaceDTO = actionSpace;
        break;
      }
    boolean playerDecidedToUseTopAction = true; //TODO: player should decide
    if (playerDecidedToUseTopAction) {
      actionSpaceDTO.actionTopCost.applyToPlayer(player);
      int picked_reward_index_move = 1;
      Reward pickedReward = actionSpaceDTO.actionTop_Rewards_toChoose_upgradable[picked_reward_index_move];
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
}