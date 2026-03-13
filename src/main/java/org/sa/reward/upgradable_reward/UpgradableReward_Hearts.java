package org.sa.reward.upgradable_reward;

import org.sa.DTO.PlayerDTO;

public class UpgradableReward_Hearts implements UpgradableReward {
  private int currentDeltaHearts;
  private int fullyUpgradedDeltaHeartsReward;

  public UpgradableReward_Hearts(int initialDeltaHeartsReward, int fullyUpgradedDeltaHeartsReward) {
    if (initialDeltaHeartsReward < 0 || fullyUpgradedDeltaHeartsReward < 0)
      throw new IllegalArgumentException("Reward should be expressed in positive values");
    this.currentDeltaHearts = initialDeltaHeartsReward;
    this.fullyUpgradedDeltaHeartsReward = fullyUpgradedDeltaHeartsReward;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.hearts += currentDeltaHearts;
  }

  @Override
  public boolean canUpgrade() {
    return currentDeltaHearts < fullyUpgradedDeltaHeartsReward;
  }

  @Override
  public void upgrade_increaseTheReward() {
    currentDeltaHearts++;
  }
}