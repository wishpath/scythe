package org.sa.reward.reward_basic;

import org.sa.DTO.PlayerDTO;
import org.sa.reward.StateChange;

public class RewardBasic_FlagTokens_Exalt implements StateChange {

  private static final int DELTA_FLAG_TOKEN_AMOUNT = 4;

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.flagTokenPool = DELTA_FLAG_TOKEN_AMOUNT;
  }

  @Override
  public int getCurrentChangeDelta() {
    return DELTA_FLAG_TOKEN_AMOUNT;
  }
}