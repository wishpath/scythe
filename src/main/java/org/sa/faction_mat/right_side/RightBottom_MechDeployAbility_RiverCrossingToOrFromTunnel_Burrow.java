package org.sa.faction_mat.right_side;

import org.sa.PlayerDTO;

/**
 * The player may move across rivers to or from tunnel territories.
 */
public class RightBottom_MechDeployAbility_RiverCrossingToOrFromTunnel_Burrow implements RightBottom_MechDeployAbility {
  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.GREEN_ALBION_mechAndCharacter_canCrossRiverToOrFromTunnel_burrow = true;
  }
}

