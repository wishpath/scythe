package org.sa.reward.enlistable_reward;

import org.sa.DTO.PlayerDTO;
import org.sa.enums.ActionBottom;

public class EnlistableReward_HeartsPlusOne implements EnlistableReward {

  private final ActionBottom triggeringAction = ActionBottom.BUILD;
  private boolean enlisted;
  private int currentDeltaHearts = 1;

  @Override
  public void enlist_turnOn() {
    enlisted = true;
  }

  @Override
  public boolean isEnlisted_isTurnedOn() {
    return enlisted;
  }

  @Override
  public boolean isTriggeredByNeighborAction(ActionBottom action) {
    return enlisted && action == triggeringAction;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    if (!enlisted) throw new IllegalStateException("Should only apply when enlisted and after trigger check.");
    for (int i = 0; i < this.currentDeltaHearts; i++)
      player.hearts++;
  }

  @Override
  public int getCurrentChangeDelta() {
    return this.currentDeltaHearts;
  }
}