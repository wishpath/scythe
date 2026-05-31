package org.sa.player_mat.a_TOPS;

import org.sa.enums.BuildingType;
import org.sa.player_mat.a_TOPS.enums_and_interfaces.TYPE_TopPart_TopActionChooseArray_ActionSpace;
import org.sa.player_mat.a_TOPS.enums_and_interfaces.TopPart;
import org.sa.player_mat.a_TOPS.upgradable_state_change_top.UpgradableStateChange_Top_Move_Decideable;
import org.sa.player_mat.a_TOPS.upgradable_state_change_top.UpgradableStateChange_Top_Reward_Coins;
import org.sa.player_mat.a_TOPS.upgradable_state_change_top.interfaces.UpgradableStateChange_Top;
import org.sa.state_change_bonus_reward_ability.cost_upgradable.UpgradableCost;
import org.sa.state_change_bonus_reward_ability.cost_upgradable.UpgradableCost_Coins;

public class TopPart_chooseBetweenMoveOrGainCoins implements TopPart {
  private TYPE_TopPart_TopActionChooseArray_ActionSpace TOP_PART_TYPE = TYPE_TopPart_TopActionChooseArray_ActionSpace.CHOOSE__MOVE__GAIN_COINS;
  private UpgradableCost FREE = new UpgradableCost_Coins(0, 0);
  private UpgradableStateChange_Top[] CHOOSE_BETWEEN_MOVE_OR_GAIN_COINS = new UpgradableStateChange_Top[] {
      new UpgradableStateChange_Top_Move_Decideable(2, 3),
      new UpgradableStateChange_Top_Reward_Coins(1, 2)
  };
  private BuildingType MINE = BuildingType.MINE;

  @Override
  public UpgradableCost getCost() {
    return this.FREE;
  }

  @Override
  public TYPE_TopPart_TopActionChooseArray_ActionSpace getTopPartType() {
    return this.TOP_PART_TYPE;
  }

  @Override
  public BuildingType getBuildingType() {
    return this.MINE;
  }

  @Override
  public UpgradableStateChange_Top[] getTopPartChoosableActions() {
    return CHOOSE_BETWEEN_MOVE_OR_GAIN_COINS;
  }
}
