package org.sa.reward.upgradable_state_change_top;

import org.sa.enums.TopStateChangeDecision_TYPE_ENUM;
import org.sa.reward.StateChange;

public interface UpgradableStateChange_Top extends StateChange {
  boolean canUpgrade();
  void upgrade_increaseTheReward();
  TopStateChangeDecision_TYPE_ENUM getDecisionType();
}
