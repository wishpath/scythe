package org.sa.decision.helper;

import org.sa.PlayerDTO;
import org.sa.grid.TileDTO;
import org.sa.locatable.locatable.BuildingType;
import org.sa.locatable.locatable.LocatableResourceType;
import org.sa.player_mat.a_top_parts.top_part_upgradable_action.TopPartUpgradableAction_Produce_Decideable;

import java.util.Map;
import java.util.Set;

public class Helper_PRODUCE {
  public static void DECIDE_andApply_TopAction_PRODUCE(TopPartUpgradableAction_Produce_Decideable produceAction, PlayerDTO player) {
    //how many tiles can produce? //workers (defined in the player mat)
    int countOfProducingTiles = produceAction.currentLimit_amountOfTilesThatCanProduce;

    //which tiles can produce //having workers (not including mill)
    Set<Map.Entry<TileDTO, Integer>> workerTile_produceAmount = player.getProducingTilesMappedToWorkerCount().entrySet();
    int countOfAlreadyProduced = 0;

    //produce from workerTile
    for (Map.Entry<TileDTO, Integer> entry : workerTile_produceAmount) { //TODO: player picks producing tiles
      TileDTO tile = entry.getKey();
      LocatableResourceType resourceType = tile.tileType.producesResourceType;
      if (resourceType == null) throw new IllegalStateException("at this point tile should be producing some resource");
      int amount = entry.getValue();
      player.addLocatableResource(resourceType, amount, tile);
      if (++countOfAlreadyProduced >= countOfProducingTiles) break;
    }

    //produce from mill
    if (player.isBuilt(BuildingType.MILL)) {
      TileDTO millLocation = player.getBuilding(BuildingType.MILL).getLocation();
      LocatableResourceType tradeableResourceOrWorker = millLocation.tileType.producesResourceType;
      if (tradeableResourceOrWorker == null) throw new IllegalStateException("mill is built on a wrong tile type");
      player.addLocatableResource(tradeableResourceOrWorker, 1, millLocation);
    }
    //no after move effects??
    player.isRightAfterMove = true;
    player.isRightAfterMove = false;
  }
}
