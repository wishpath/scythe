package org.sa.b_storage.reward;

import org.sa.DTO.PlayerDTO;

public class Reward_Coins implements Reward {
  private int deltaCoins;

  public Reward_Coins(int deltaCoins) {
    this.deltaCoins = deltaCoins;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.coins += deltaCoins;
  }
}
