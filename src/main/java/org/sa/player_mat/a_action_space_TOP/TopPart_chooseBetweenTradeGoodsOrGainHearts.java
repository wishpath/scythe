package org.sa.player_mat.a_action_space_TOP;

import org.sa.player_mat.a_action_space_TOP.upgradable_state_change_top.UpgradableStateChange_Top;
import org.sa.player_mat.a_action_space_TOP.upgradable_state_change_top.UpgradableStateChange_Top_Hearts;
import org.sa.player_mat.x.BuildingType;
import org.sa.state_change_bonus_reward_ability.cost_upgradable.UpgradableCost;
import org.sa.state_change_bonus_reward_ability.cost_upgradable.UpgradableCost_Coins;

public class TopPart_chooseBetweenTradeGoodsOrGainHearts implements TopPart {
  private TYPE_TopPart_TopActionChooseArray_ActionSpace TOP_PART_TYPE = TYPE_TopPart_TopActionChooseArray_ActionSpace.CHOOSE__TRADE__GAIN_HEARTS;
  private UpgradableCost ONE_COIN = new UpgradableCost_Coins(1, 1);
  private UpgradableStateChange_Top[] TOP_PART_CHOOSABLE_ACTIONS = new UpgradableStateChange_Top[] {
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
    return new UpgradableStateChange_Top[0];
  }
}
