package org.sa.reward;

import org.sa.DTO.PlayerDTO;

public class Reward_FlagTokens_Exalt implements Reward {

  private static final int DELTA_FLAG_TOKEN_AMOUNT = 4;

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.flagTokenPool = DELTA_FLAG_TOKEN_AMOUNT;
  }
}