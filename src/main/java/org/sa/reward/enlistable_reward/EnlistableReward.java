package org.sa.reward.enlistable_reward;

import org.sa.enums.ActionBottom;
import org.sa.reward.StateChange;

public interface EnlistableReward extends StateChange {
  void enlist_turnOn();
  boolean isEnlisted_isTurnedOn();
  boolean isTriggeredByNeighborAction(ActionBottom triggeringNeighborActionBottom);
}
