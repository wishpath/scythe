package org.sa.state_change_bonus_reward_ability.get_ability;

import org.sa.PlayerDTO;
import org.sa.state_change_bonus_reward_ability.StateChange;

/**
 * Before combat where the player is attacking,
 * the opponent gets −2 attack power.
 */
public class MechDeployAbility_MinusAttackForOpponent_Sword implements StateChange {
  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.GREEN_ALBION_opponentGetsMinus2AttackBeforeYouAttackHim_sword = true;
  }

  @Override
  public int getCurrentChangeDelta() {
    throw new IllegalStateException("This ability does have quantifiable delta value");
  }
}
