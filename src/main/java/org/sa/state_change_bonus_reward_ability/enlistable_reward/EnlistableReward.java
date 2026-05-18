package org.sa.state_change_bonus_reward_ability.enlistable_reward;

import org.sa.enums.player_mat_enum.ActionBottom;
import org.sa.state_change_bonus_reward_ability.StateChange;

public interface EnlistableReward extends StateChange {
  void enlist_turnOn();
  boolean isEnlisted_isTurnedOn();
  boolean isTriggeredByNeighborAction(ActionBottom triggeringNeighborActionBottom);
}
