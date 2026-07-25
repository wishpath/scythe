package org.sa.faction_mat.right_side;

import org.sa.PlayerDTO;

/**
 * Allows moving a character to a territory,
 * where player has a worker or Flag token.
 */
public class RightBottom_MechDeployAbility_CanMoveToWorkerOrFlagTokenTerritory_Rally implements RightBottom_MechDeployAbility {
  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.GREEN_ALBION_mechAndCharacter_canMoveToWorkerOrFlagTokenTerritory_rally = true;
  }
}
