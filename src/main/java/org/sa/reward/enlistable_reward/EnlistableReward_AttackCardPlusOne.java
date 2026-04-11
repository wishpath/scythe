package org.sa.reward.enlistable_reward;

import org.sa.DTO.PlayerDTO;
import org.sa.b_storage.CardPool;
import org.sa.enums.ActionBottom;

public class EnlistableReward_AttackCardPlusOne implements EnlistableReward {

  private final ActionBottom triggeringAction = ActionBottom.ENLIST;
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
  public boolean isTriggeredByNeighborAction(ActionBottom action) {
    return enlisted && action == triggeringAction;
  }

  public void applyToPlayer(PlayerDTO player) {
    if (!enlisted) throw new IllegalStateException(
        "Should only apply when enlisted and after trigger check."
    );
    for (int i = 0; i < this.currentDeltaCards; i++)
      player.attackCards.add(CardPool.drawAttackCard());
  }

  @Override
  public int getCurrentChangeDelta() {
    return this.currentDeltaCards; // one card is added
  }
}
