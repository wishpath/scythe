package org.sa.faction_mat.right_side;

import org.sa.PlayerDTO;

public class RightTop_FactionAbility_FlagTokens_Exalt_GREEN implements RightTop_FactionAbility {

  private static final int DELTA_FLAG_TOKEN_AMOUNT = 4;

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.GREEN_ALBION_flagTokenPool_exalt = DELTA_FLAG_TOKEN_AMOUNT;
  }
}