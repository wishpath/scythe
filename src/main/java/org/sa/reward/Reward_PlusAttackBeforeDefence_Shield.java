package org.sa.reward;

import org.sa.DTO.PlayerDTO;

/**
 * Before combat where the player is defending,
 * the player gets +2 attack power.
 */
public class Reward_PlusAttackBeforeDefence_Shield implements Reward {

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.playerGets2AttackBeforeDefence = true;
  }
}