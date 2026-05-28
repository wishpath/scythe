package org.sa.player_mat.a_action_space_TOP;

import org.sa.player_mat.x.BuildingType;
import org.sa.state_change_bonus_reward_ability.cost_upgradable.UpgradableCost;
import org.sa.state_change_bonus_reward_ability.cost_upgradable.UpgradableCost_Coins;
import org.sa.player_mat.a_action_space_TOP.upgradable_state_change_top.UpgradableStateChange_Top;
import org.sa.player_mat.a_action_space_TOP.upgradable_state_change_top.UpgradableStateChange_Top_Move;
import org.sa.player_mat.a_action_space_TOP.upgradable_state_change_top.UpgradableStateChange_Top_Reward_Coins;

public class TopPart_chooseBetweenMoveOrGainCoins implements TopPart {
  private TYPE_TopPart_TopActionChooseArray_ActionSpace TOP_PART_TYPE = TYPE_TopPart_TopActionChooseArray_ActionSpace.CHOOSE__MOVE__GAIN_COINS;
  private UpgradableCost FREE = new UpgradableCost_Coins(0, 0);
  private UpgradableStateChange_Top[] TOP_PART_CHOOSABLE_ACTIONS = new UpgradableStateChange_Top[] {
      new UpgradableStateChange_Top_Move(2, 3),
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
    return new UpgradableStateChange_Top[0];
  }
}
