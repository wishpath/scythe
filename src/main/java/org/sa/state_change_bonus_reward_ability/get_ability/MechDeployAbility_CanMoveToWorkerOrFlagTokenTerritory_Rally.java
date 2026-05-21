package org.sa.state_change_bonus_reward_ability.get_ability;

import org.sa.DTO.PlayerDTO;
import org.sa.state_change_bonus_reward_ability.StateChange;

/**
 * Allows moving a character to a territory,
 * where player has a worker or Flag token.
 */
public class MechDeployAbility_CanMoveToWorkerOrFlagTokenTerritory_Rally implements StateChange {

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.GREEN_ALBION_mechAndCharacter_canMoveToWorkerOrFlagTokenTerritory_rally = true;
  }

  @Override
  public int getCurrentChangeDelta() {
    throw new IllegalStateException("This ability does have quantifiable delta value");
  }
}
