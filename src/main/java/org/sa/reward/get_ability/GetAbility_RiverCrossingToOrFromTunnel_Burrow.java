package org.sa.reward.get_ability;

import org.sa.DTO.PlayerDTO;
import org.sa.reward.StateChange;

/**
 * The player may move across rivers to or from tunnel territories.
 */
public class GetAbility_RiverCrossingToOrFromTunnel_Burrow implements StateChange {

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.ALBION_opponentGetsMinus2AttackBeforeYouAttackHim = true;
  }

  @Override
  public int getCurrentChangeDelta() {
    throw new IllegalStateException("This ability does have quantifiable delta value");
  }
}

