package org.sa.reward.cost_upgradable;

import org.sa.reward.Reward;

public interface UpgradableCost extends Reward {

  boolean canUpgrade();

  void upgrade_lowerTheCost();
}
