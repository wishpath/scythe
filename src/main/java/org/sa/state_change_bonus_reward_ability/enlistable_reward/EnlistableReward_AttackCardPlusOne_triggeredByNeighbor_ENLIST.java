package org.sa.state_change_bonus_reward_ability.enlistable_reward;

import org.sa.DTO.PlayerDTO;
import org.sa.enums.ResourceType;
import org.sa.player_mat.bottom_parts.enums_and_interfaces.BottomPartType;

public class EnlistableReward_AttackCardPlusOne_triggeredByNeighbor_ENLIST implements EnlistableReward {

  private final BottomPartType triggeringAction = BottomPartType.ENLIST;
  private boolean enlisted;
  private int currentDeltaCards = 1;

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

  public void applyToPlayer(PlayerDTO player) {
    if (!enlisted) throw new IllegalStateException(
        "Should only apply when enlisted and after trigger check."
    );
    player.addResource(ResourceType.COMBAT_CARDS, currentDeltaCards);
  }

  @Override
  public int getCurrentChangeDelta() {
    return this.currentDeltaCards; // one card is added
  }
}
