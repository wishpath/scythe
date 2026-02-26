package org.sa.reward.ability;

import org.sa.DTO.PlayerDTO;
import org.sa.reward.Reward;

/**
 * Allows moving a character to a territory,
 * where player has a worker or Flag token.
 */
public class Ability_CanMoveToControlledTerritory_Rally implements Reward {

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.canMoveCharacterToControlledTerritory = true;
  }
}
