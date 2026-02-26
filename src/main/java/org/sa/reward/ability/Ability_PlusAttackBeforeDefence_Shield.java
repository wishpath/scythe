package org.sa.reward.ability;

import org.sa.DTO.PlayerDTO;
import org.sa.reward.Reward;

/**
 * Before combat where the player is defending,
 * the player gets +2 attack power.
 */
public class Ability_PlusAttackBeforeDefence_Shield implements Reward {

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.playerGets2AttackBeforeDefence = true;
  }
}