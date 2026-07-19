package org.sa.player_mat.a_top_parts;

import org.sa.placeable.locatable.BuildingType;
import org.sa.player_mat.a_top_parts.enums_and_interfaces.TYPE__TopPart__TopPartChooseActionArray__ActionSpace;
import org.sa.player_mat.a_top_parts.enums_and_interfaces.TopPart;
import org.sa.player_mat.a_top_parts.top_part_cost.TopPartCost;
import org.sa.player_mat.a_top_parts.top_part_cost.TopPartCost_Minus1Coin;
import org.sa.player_mat.a_top_parts.top_part_upgradable_action.TopPartUpgradableAction_Hearts;
import org.sa.player_mat.a_top_parts.top_part_upgradable_action.TopPartUpgradableAction_Trade_Decideable;
import org.sa.player_mat.a_top_parts.top_part_upgradable_action.interfaces.TopPartUpgradableAction;

public class TopPart_chooseBetweenTradeGoodsOrGainHearts implements TopPart {
  private TYPE__TopPart__TopPartChooseActionArray__ActionSpace TOP_PART_TYPE__CHOOSE__TRADE__GAIN_HEARTS = TYPE__TopPart__TopPartChooseActionArray__ActionSpace.CHOOSE__TRADE__GAIN_HEARTS;
  private TopPartCost MINUS_ONE_COIN = new TopPartCost_Minus1Coin();
  private TopPartUpgradableAction[] CHOOSE_BETWEEN_TRADE_OR_GAIN_HEARTS = new TopPartUpgradableAction[] {
      new TopPartUpgradableAction_Hearts(1, 2),
      new TopPartUpgradableAction_Trade_Decideable(2, 2)
  };
  private BuildingType ARMORY = BuildingType.ARMORY; // building state stored in PlayerDTO.buildingType_isBuilt

  @Override
  public TopPartCost getCost() {
    return this.MINUS_ONE_COIN;
  }

  @Override
  public TYPE__TopPart__TopPartChooseActionArray__ActionSpace getTopPartType() {
    return this.TOP_PART_TYPE__CHOOSE__TRADE__GAIN_HEARTS;
  }

  @Override
  public BuildingType getBuildingType() {
    return this.ARMORY;
  }

  @Override
  public TopPartUpgradableAction[] getTopPartChoosableActions() {
    return CHOOSE_BETWEEN_TRADE_OR_GAIN_HEARTS;
  }
}
