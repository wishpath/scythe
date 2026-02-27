package org.sa.reward.reward_enlistable;

import org.sa.reward.Reward;

public interface UpgradableCost extends Reward {

  boolean canUpgrade();

  void upgrade_lowerTheCost();
}
