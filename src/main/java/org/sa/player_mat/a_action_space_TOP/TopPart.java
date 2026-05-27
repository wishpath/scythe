package org.sa.player_mat.a_action_space_TOP;

import org.sa.player_mat.x.BuildingType;
import org.sa.state_change_bonus_reward_ability.cost_upgradable.UpgradableCost;
import org.sa.player_mat.a_action_space_TOP.upgradable_state_change_top.UpgradableStateChange_Top;

public interface TopPart {
  public UpgradableCost getCost();
  public ActionTopType_ActionSpaceType getTopPartType();
  public BuildingType getBuildingType();
  public UpgradableStateChange_Top[] getTopPartChoosableActions();
}
