package org.sa.player_mat.a_TOPS.enums_and_interfaces;

import org.sa.player_mat.a_TOPS.upgradable_state_change_top.interfaces.UpgradableStateChange_Top;
import org.sa.enums.BuildingType;
import org.sa.state_change_bonus_reward_ability.cost_upgradable.UpgradableCost;

public interface TopPart {
  public UpgradableCost getCost();
  public TYPE_TopPart_TopActionChooseArray_ActionSpace getTopPartType();
  public BuildingType getBuildingType();
  public UpgradableStateChange_Top[] getTopPartChoosableActions();
}
