package org.sa.reward;

import org.sa.DTO.PlayerDTO;

/**
 * Allows moving a character to a territory,
 * where player has a worker or Flag token.
 */
public class Reward_CanMoveToControlledTerritory_Rally implements Reward {

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.canMoveCharacterToControlledTerritory = true;
  }
}
