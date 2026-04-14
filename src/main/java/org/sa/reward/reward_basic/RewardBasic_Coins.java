package org.sa.reward.reward_basic;

import org.sa.DTO.PlayerDTO;
import org.sa.reward.StateChange;

public class RewardBasic_Coins implements StateChange {
  private int deltaCoins;

  public RewardBasic_Coins(int deltaCoins) {
    this.deltaCoins = deltaCoins;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.coins += deltaCoins;
  }

  @Override
  public int getCurrentChangeDelta() {
    return deltaCoins;
  }
}
