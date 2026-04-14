package org.sa.reward.reward_basic;

import org.sa.DTO.PlayerDTO;
import org.sa.b_storage.CardPool;
import org.sa.reward.StateChange;

public class RewardBasic_AttackCards implements StateChange {
  private int deltaAttackCardAmount;

  public RewardBasic_AttackCards(int deltaAttackCardAmount) {
    this.deltaAttackCardAmount = deltaAttackCardAmount;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    for (int i = 0; i < deltaAttackCardAmount; i++) {
      player.attackCards.add(CardPool.drawAttackCard());
    }
  }

  @Override
  public int getCurrentChangeDelta() {
    return deltaAttackCardAmount;
  }
}
