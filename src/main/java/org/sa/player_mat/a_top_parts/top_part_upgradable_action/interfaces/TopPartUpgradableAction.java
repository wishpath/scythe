package org.sa.player_mat.a_top_parts.top_part_upgradable_action.interfaces;

import org.sa.player_mat.a_top_parts.enums_and_interfaces.TopPartDecision_TYPE_ENUM;

public interface TopPartUpgradableAction {
  int getCurrentChangeDelta();
  boolean canUpgrade();
  void upgrade_increaseTheReward();
  TopPartDecision_TYPE_ENUM getDecisionType();
}
