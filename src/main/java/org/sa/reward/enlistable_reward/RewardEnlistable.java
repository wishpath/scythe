package org.sa.reward.enlistable_reward;

import org.sa.enums.ActionBottom;

public interface RewardEnlistable {
  void enlist_turnOn();
  boolean isEnlisted_isTurnedOn();
  boolean isTriggeredByNeighborAction(ActionBottom triggeringNeighborActionBottom);
}
