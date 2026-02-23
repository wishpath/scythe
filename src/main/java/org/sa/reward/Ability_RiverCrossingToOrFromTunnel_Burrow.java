package org.sa.reward;

import org.sa.DTO.PlayerDTO;

/**
 * The player may move across rivers to or from tunnel territories.
 */
public class Ability_RiverCrossingToOrFromTunnel_Burrow implements Reward {

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.opponentGetsMinus2AttackBeforeYouAttackHim = true;
  }
}

