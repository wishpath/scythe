package org.sa.b_storage.reward;

import org.sa.DTO.PlayerDTO;

/**
 * Before combat where the player is attacking,
 * the opponent gets −2 attack power.
 */
public class Reward_MinusAttackForOpponent_Sword implements Reward {
  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.opponentGetsMinus2AttackBeforeYouAttackHim = true;
  }
}
