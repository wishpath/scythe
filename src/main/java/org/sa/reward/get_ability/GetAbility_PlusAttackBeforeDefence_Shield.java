package org.sa.reward.get_ability;

import org.sa.DTO.PlayerDTO;
import org.sa.reward.StateChange;

/**
 * Before combat where the player is defending,
 * the player gets +2 attack power.
 */
public class GetAbility_PlusAttackBeforeDefence_Shield implements StateChange {

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.playerGets2AttackBeforeDefence = true;
  }
}