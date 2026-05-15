package org.sa.state_change_bonus_reward_ability.get_ability;

import org.sa.DTO.PlayerDTO;
import org.sa.state_change_bonus_reward_ability.StateChange;

/**
 * Before combat where the player is defending,
 * the player gets +2 attack power.
 */
public class MechDeployAbility_PlusAttackBeforeDefence_Shield implements StateChange {

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.GREEN_ALBION_playerGets2AttackBeforeDefence_shield = true;
  }

  @Override
  public int getCurrentChangeDelta() {
    throw new IllegalStateException("This ability does have quantifiable delta value");
  }
}