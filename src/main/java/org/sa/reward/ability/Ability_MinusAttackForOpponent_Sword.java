package org.sa.reward.ability;

import org.sa.DTO.PlayerDTO;
import org.sa.reward.Reward;

/**
 * Before combat where the player is attacking,
 * the opponent gets −2 attack power.
 */
public class Ability_MinusAttackForOpponent_Sword implements Reward {
  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.opponentGetsMinus2AttackBeforeYouAttackHim = true;
  }
}
