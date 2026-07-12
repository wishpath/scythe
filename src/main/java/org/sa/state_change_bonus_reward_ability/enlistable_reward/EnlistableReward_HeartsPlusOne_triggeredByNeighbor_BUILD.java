package org.sa.state_change_bonus_reward_ability.enlistable_reward;

import org.sa.DTO.PlayerDTO;
import org.sa.enums.ResourceType;
import org.sa.player_mat.bottom_parts.enums_and_interfaces.BottomPartType;

public class EnlistableReward_HeartsPlusOne_triggeredByNeighbor_BUILD implements EnlistableReward {

  private final BottomPartType triggeringAction = BottomPartType.BUILD;
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
  public boolean isTriggeredByNeighborAction(BottomPartType action) {
    return enlisted && action == triggeringAction;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    if (!enlisted) throw new IllegalStateException("Should only apply when enlisted and after trigger check.");
    for (int i = 0; i < this.currentDeltaHearts; i++)
      player.addResource(ResourceType.HEARTS, 1);
  }

  @Override
  public int getCurrentChangeDelta() {
    return this.currentDeltaHearts;
  }
}