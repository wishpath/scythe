package org.sa.reward.cost_upgradable;

import org.sa.reward.StateChange;

public interface UpgradableCost extends StateChange {

  boolean canUpgrade();

  void upgrade_lowerTheCost();
}
