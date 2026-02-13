package org.sa.b_storage.reward;

import org.sa.DTO.PlayerDTO;

public class Reward_FlagTokens implements Reward {

  private static final int DELTA_FLAG_TOKEN_AMOUNT = 4;

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.flagTokenPool = DELTA_FLAG_TOKEN_AMOUNT;
  }
}