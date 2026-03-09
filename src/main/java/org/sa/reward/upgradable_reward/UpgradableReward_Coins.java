package org.sa.reward.upgradable_reward;

import org.sa.DTO.PlayerDTO;

public class UpgradableReward_Coins implements UpgradableReward {
  private int currentDeltaCoins;
  private int fullyUpgradedDeltaCoinsReward;

  public UpgradableReward_Coins(int initialDeltaCoinsReward, int fullyUpgradedDeltaCoinsReward) {
    if (initialDeltaCoinsReward < 0 || fullyUpgradedDeltaCoinsReward < 0)
      throw new IllegalArgumentException("Reward should be expressed in positive values");
    this.currentDeltaCoins = initialDeltaCoinsReward;
    this.fullyUpgradedDeltaCoinsReward = fullyUpgradedDeltaCoinsReward;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.coins += currentDeltaCoins;
  }

  @Override
  public boolean canUpgrade() {
    return currentDeltaCoins < fullyUpgradedDeltaCoinsReward;
  }

  @Override
  public void upgrade_increaseTheReward() {
    currentDeltaCoins++;
  }
}