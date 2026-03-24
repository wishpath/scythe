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
    player.canMoveCharacterToControlledTerritory = true;
  }
}
