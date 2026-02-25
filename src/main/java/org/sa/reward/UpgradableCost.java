package org.sa.reward;

public interface UpgradableCost extends Reward {

  boolean canUpgrade();

  void upgrade_lowerTheCost();
}
