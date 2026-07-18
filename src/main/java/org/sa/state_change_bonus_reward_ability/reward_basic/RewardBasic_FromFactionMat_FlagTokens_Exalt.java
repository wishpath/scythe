package org.sa.state_change_bonus_reward_ability.reward_basic;

import org.sa.PlayerDTO;
import org.sa.state_change_bonus_reward_ability.StateChange;

public class RewardBasic_FromFactionMat_FlagTokens_Exalt implements StateChange {

  private static final int DELTA_FLAG_TOKEN_AMOUNT = 4;

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.GREEN_ALBION_flagTokenPool_exalt = DELTA_FLAG_TOKEN_AMOUNT;
  }

  @Override
  public int getCurrentChangeDelta() {
    return DELTA_FLAG_TOKEN_AMOUNT;
  }
}