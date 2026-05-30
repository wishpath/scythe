package org.sa.player_mat.a_TOPS;

import org.sa.player_mat.a_TOPS.enums_and_interfaces.TYPE_TopPart_TopActionChooseArray_ActionSpace;
import org.sa.player_mat.a_TOPS.enums_and_interfaces.TopPart;
import org.sa.player_mat.a_TOPS.upgradable_state_change_top.UpgradableStateChange_Top_Hearts;
import org.sa.player_mat.a_TOPS.upgradable_state_change_top.UpgradableStateChange_Top_Trade;
import org.sa.player_mat.a_TOPS.upgradable_state_change_top.interfaces.UpgradableStateChange_Top;
import org.sa.enums.BuildingType;
import org.sa.state_change_bonus_reward_ability.cost_upgradable.UpgradableCost;
import org.sa.state_change_bonus_reward_ability.cost_upgradable.UpgradableCost_Coins;

public class TopPart_chooseBetweenTradeGoodsOrGainHearts implements TopPart {
  private TYPE_TopPart_TopActionChooseArray_ActionSpace TOP_PART_TYPE = TYPE_TopPart_TopActionChooseArray_ActionSpace.CHOOSE__TRADE__GAIN_HEARTS;
  private UpgradableCost ONE_COIN = new UpgradableCost_Coins(-1, -1);
  private UpgradableStateChange_Top[] CHOOSE_BETWEEN_TRADE_OR_GAIN_HEARTS = new UpgradableStateChange_Top[] {
      new UpgradableStateChange_Top_Hearts(1, 2),
      new UpgradableStateChange_Top_Trade(2, 2)
  };
  private BuildingType ARMORY = BuildingType.ARMORY;

  @Override
  public UpgradableCost getCost() {
    return this.ONE_COIN;
  }

  @Override
  public TYPE_TopPart_TopActionChooseArray_ActionSpace getTopPartType() {
    return this.TOP_PART_TYPE;
  }

  @Override
  public BuildingType getBuildingType() {
    return this.ARMORY;
  }

  @Override
  public UpgradableStateChange_Top[] getTopPartChoosableActions() {
    return CHOOSE_BETWEEN_TRADE_OR_GAIN_HEARTS;
  }
}
