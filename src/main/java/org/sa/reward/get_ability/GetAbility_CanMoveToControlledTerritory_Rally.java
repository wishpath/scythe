package org.sa.reward.get_ability;

import org.sa.DTO.PlayerDTO;
import org.sa.reward.StateChange;

/**
 * Allows moving a character to a territory,
 * where player has a worker or Flag token.
 */
public class GetAbility_CanMoveToControlledTerritory_Rally implements StateChange {

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.ALBION_canMoveCharacterToControlledTerritory_rally = true;
  }

  @Override
  public int getCurrentChangeDelta() {
    throw new IllegalStateException("This ability does have quantifiable delta value");
  }
}
