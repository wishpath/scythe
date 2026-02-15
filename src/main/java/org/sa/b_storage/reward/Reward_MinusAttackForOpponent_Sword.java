package org.sa.b_storage.reward;

import org.sa.DTO.PlayerDTO;

public class Reward_MinusAttackForOpponent_Sword implements Reward {
  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.opponentGetsMinus2AttackBeforeYouAttackHim = true;
  }
}
