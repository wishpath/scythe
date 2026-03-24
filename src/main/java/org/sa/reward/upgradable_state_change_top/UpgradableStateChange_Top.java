package org.sa.reward.upgradable_state_change_top;

import org.sa.enums.TopStateChangeDecisionType;
import org.sa.reward.StateChange;

public interface UpgradableStateChange_Top extends StateChange {
  boolean canUpgrade();
  void upgrade_increaseTheReward();
  TopStateChangeDecisionType getDecisionType();
}
