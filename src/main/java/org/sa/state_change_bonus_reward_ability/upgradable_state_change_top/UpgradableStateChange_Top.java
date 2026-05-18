package org.sa.state_change_bonus_reward_ability.upgradable_state_change_top;

import org.sa.enums.player_mat_enum.TopStateChangeDecision_TYPE_ENUM;
import org.sa.state_change_bonus_reward_ability.StateChange;

public interface UpgradableStateChange_Top extends StateChange {
  boolean canUpgrade();
  void upgrade_increaseTheReward();
  TopStateChangeDecision_TYPE_ENUM getDecisionType();
}
