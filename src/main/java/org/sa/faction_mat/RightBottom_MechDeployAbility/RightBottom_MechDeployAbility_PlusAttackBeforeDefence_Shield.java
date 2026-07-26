package org.sa.faction_mat.RightBottom_MechDeployAbility;

import org.sa.PlayerDTO;

/**
 * Before combat where the player is defending,
 * the player gets +2 attack power.
 */
public class RightBottom_MechDeployAbility_PlusAttackBeforeDefence_Shield implements RightBottom_MechDeployAbility {
  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.GREEN_ALBION_playerGets2AttackBeforeDefence_shield = true;
  }
}