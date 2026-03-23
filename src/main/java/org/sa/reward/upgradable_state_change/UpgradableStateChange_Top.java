package org.sa.reward.upgradable_state_change;

import org.sa.enums.TopStateChangeDecisionType;
import org.sa.reward.Reward;

public interface UpgradableStateChange_Top extends Reward {
  boolean canUpgrade();
  void upgrade_increaseTheReward();
  TopStateChangeDecisionType getDecisionType();
}
