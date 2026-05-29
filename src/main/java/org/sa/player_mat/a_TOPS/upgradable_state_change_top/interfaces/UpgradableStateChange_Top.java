package org.sa.player_mat.a_TOPS.upgradable_state_change_top.interfaces;

import org.sa.player_mat.a_TOPS.enums_and_interfaces.TopStateChangeDecision_TYPE_ENUM;

public interface UpgradableStateChange_Top {
  int getCurrentChangeDelta();
  boolean canUpgrade();
  void upgrade_increaseTheReward();
  TopStateChangeDecision_TYPE_ENUM getDecisionType();
}
