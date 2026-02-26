package org.sa.reward.upgradable_cost;

import org.sa.reward.Reward;

public interface UpgradableCost extends Reward {

  boolean canUpgrade();

  void upgrade_lowerTheCost();
}
