package org.sa.state_change_bonus_reward_ability.enlistable_reward;

import org.sa.DTO.PlayerDTO;
import org.sa.enums.ResourceType;
import org.sa.player_mat.bottom_parts.enums_and_interfaces.BottomPartType;

public class EnlistableReward_AttackPlusOne_triggeredByNeighbor_UPGRADE implements EnlistableReward {

  private final BottomPartType triggeringAction = BottomPartType.UPGRADE;
  private boolean enlisted;
  private int currentDeltaAttack = 1;


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
    player.addResource(ResourceType.ATTACK, currentDeltaAttack);
  }

  @Override
  public int getCurrentChangeDelta() {
    return this.currentDeltaAttack; // one attack is added
  }
}
