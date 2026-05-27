package org.sa.player_mat.a_action_space_TOP.upgradable_state_change_top;

import org.sa.player_mat.x.TopStateChangeDecision_TYPE_ENUM;
import org.sa.state_change_bonus_reward_ability.StateChange;

public interface UpgradableStateChange_Top extends StateChange {
  boolean canUpgrade();
  void upgrade_increaseTheReward();
  TopStateChangeDecision_TYPE_ENUM getDecisionType();
}
