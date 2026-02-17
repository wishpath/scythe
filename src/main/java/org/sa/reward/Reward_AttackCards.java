package org.sa.reward;

import org.sa.DTO.PlayerDTO;
import org.sa.b_storage.CardPool;

public class Reward_AttackCards implements Reward {
  private int deltaAttackCardAmount;

  public Reward_AttackCards(int deltaAttackCardAmount) {
    this.deltaAttackCardAmount = deltaAttackCardAmount;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    for (int i = 0; i < deltaAttackCardAmount; i++) {
      player.attackCards.add(CardPool.drawAttackCard());
    }
  }
}
