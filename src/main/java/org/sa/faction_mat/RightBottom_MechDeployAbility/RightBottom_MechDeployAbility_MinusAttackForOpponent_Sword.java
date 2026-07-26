package org.sa.faction_mat.RightBottom_MechDeployAbility;

import org.sa.PlayerDTO;

/**
 * Before combat where the player is attacking,
 * the opponent gets −2 attack power.
 */
public class RightBottom_MechDeployAbility_MinusAttackForOpponent_Sword implements RightBottom_MechDeployAbility {
  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.GREEN_ALBION_opponentGetsMinus2AttackBeforeYouAttackHim_sword = true;
  }
}
