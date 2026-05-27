package org.sa.player_mat.a_action_space_TOP;

import org.sa.player_mat.x.BuildingType;
import org.sa.state_change_bonus_reward_ability.cost_upgradable.UpgradableCost;
import org.sa.state_change_bonus_reward_ability.cost_upgradable.UpgradableCost_Coins;
import org.sa.player_mat.a_action_space_TOP.upgradable_state_change_top.UpgradableStateChange_Top;
import org.sa.player_mat.a_action_space_TOP.upgradable_state_change_top.UpgradableStateChange_Top_Move;
import org.sa.player_mat.a_action_space_TOP.upgradable_state_change_top.UpgradableStateChange_Top_Reward_Coins;

public class TopPart_chooseBetweenMoveOrGainCoins implements TopPart {
  private ActionTopType_ActionSpaceType TOP_PART_TYPE = ActionTopType_ActionSpaceType.CHOOSE__MOVE__GAIN_COIN;
  private UpgradableCost FREE = new UpgradableCost_Coins(0, 0);
  private UpgradableStateChange_Top[] TOP_PART_CHOOSABLE_ACTIONS = new UpgradableStateChange_Top[] {
      new UpgradableStateChange_Top_Move(2, 3),
      new UpgradableStateChange_Top_Reward_Coins(1, 2)
  };
  private BuildingType BUILDING_TYPE = BuildingType.MINE;

  @Override
  public UpgradableCost getCost() {
    return this.FREE;
  }

  @Override
  public ActionTopType_ActionSpaceType getTopPartType() {
    return this.TOP_PART_TYPE;
  }

  @Override
  public BuildingType getBuildingType() {
    return this.BUILDING_TYPE;
  }

  @Override
  public UpgradableStateChange_Top[] getTopPartChoosableActions() {
    return new UpgradableStateChange_Top[0];
  }
}
