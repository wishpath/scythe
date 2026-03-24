package org.sa.reward.get_ability;

import org.sa.DTO.PlayerDTO;
import org.sa.reward.StateChange;

/**
 * Before combat where the player is attacking,
 * the opponent gets −2 attack power.
 */
public class GetAbility_MinusAttackForOpponent_Sword implements StateChange {
  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.opponentGetsMinus2AttackBeforeYouAttackHim = true;
  }
}
