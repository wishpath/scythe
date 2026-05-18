package org.sa.state_change_bonus_reward_ability.enlistable_reward;

import org.sa.DTO.PlayerDTO;
import org.sa.enums.player_mat_enum.ActionBottom;

public class EnlistableReward_AttackPlusOne_triggeredByNeighbor_UPGRADE implements EnlistableReward {

  private final ActionBottom triggeringAction = ActionBottom.UPGRADE;
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
  public boolean isTriggeredByNeighborAction(ActionBottom action) {
    return enlisted && action == triggeringAction;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    if (!enlisted) throw new IllegalStateException(
        "Should only apply when enlisted and after trigger check."
    );
    for (int i = 0; i < this.currentDeltaAttack; i++)
      player.attack++;
  }

  @Override
  public int getCurrentChangeDelta() {
    return this.currentDeltaAttack; // one attack is added
  }
}
