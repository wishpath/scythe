package org.sa.reward;

public interface UpgradableReward extends Reward {

  boolean canUpgrade();

  void upgrade_lowerCost();
}
