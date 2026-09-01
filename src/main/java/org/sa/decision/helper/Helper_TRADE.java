package org.sa.decision.helper;

import org.sa.PlayerDTO;
import org.sa.grid.TileDTO;
import org.sa.locatable.locatable.BuildingType;
import org.sa.locatable.locatable.LocatableResourceType;
import org.sa.player_mat.a_top_parts.top_part_upgradable_action.TopPartUpgradableAction_Trade_Decideable;

public class Helper_TRADE {
  public static void DECIDE_andApply_TopAction_TRADE(TopPartUpgradableAction_Trade_Decideable tradeAction, PlayerDTO player) {
    //choose resource types
    LocatableResourceType tradeableResourceType1 = LocatableResourceType.getTradeableResourceTypes().get(0); //TODO: player picks resource type1 to get
    LocatableResourceType tradeableResourceType2 = LocatableResourceType.getTradeableResourceTypes().get(0); //TODO: player picks resource type2 to get
    if (tradeableResourceType1 == null || tradeableResourceType2 == null || !tradeableResourceType1.canGetThroughTradeAction || !tradeableResourceType2.canGetThroughTradeAction) throw new IllegalArgumentException("plyer should pick a tradeable resource");

    // place resources on the board
    TileDTO mostPowerfulTileWithWorkers = player.getWorkerTileWithMostPower(); //for the sake of simplicity defining best tile algorithmically. otherwise player could choose.
    player.addTradeableResource(tradeableResourceType1, 1, mostPowerfulTileWithWorkers);
    player.addTradeableResource(tradeableResourceType2, 1, mostPowerfulTileWithWorkers);

    //gain combat cards from armory
    if (player.isBuilt(BuildingType.ARMORY)) player.addCombatCard(1);

    //no after move effects??
    player.isRightAfterMove = true;
    player.isRightAfterMove = false;
  }
}
