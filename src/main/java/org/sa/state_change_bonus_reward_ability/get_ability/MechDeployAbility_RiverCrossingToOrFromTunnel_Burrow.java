package org.sa.state_change_bonus_reward_ability.get_ability;

import org.sa.DTO.PlayerDTO;
import org.sa.state_change_bonus_reward_ability.StateChange;

/**
 * The player may move across rivers to or from tunnel territories.
 */
public class MechDeployAbility_RiverCrossingToOrFromTunnel_Burrow implements StateChange {

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.GREEN_ALBION_mechAndCharacter_canCrossRiverToOrFromTunnel_burrow = true;
  }

  @Override
  public int getCurrentChangeDelta() {
    throw new IllegalStateException("This ability does have quantifiable delta value");
  }
}

