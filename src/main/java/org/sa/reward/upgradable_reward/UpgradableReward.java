package org.sa.reward.upgradable_reward;

import org.sa.reward.Reward;

public interface UpgradableReward extends Reward {
  boolean canUpgrade();
  void upgrade_increaseTheReward();
}
