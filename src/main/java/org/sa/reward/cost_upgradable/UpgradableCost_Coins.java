package org.sa.reward.cost_upgradable;

import org.sa.DTO.PlayerDTO;

public class UpgradableCost_Coins implements UpgradableCost {
  private int currentDeltaCoins;
  private int fullyUpgradedDeltaCoinsCost;

  public UpgradableCost_Coins(int initialDeltaCoinsCost, int fullyUpgradedDeltaCoinsCost) {
    if (initialDeltaCoinsCost > 0 || fullyUpgradedDeltaCoinsCost > 0)
      throw new IllegalArgumentException("Cost should be expressed in negative values");
    this.currentDeltaCoins = initialDeltaCoinsCost;
    this.fullyUpgradedDeltaCoinsCost = fullyUpgradedDeltaCoinsCost;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.coins += currentDeltaCoins;
  }

  @Override
  public boolean canUpgrade() {
    return currentDeltaCoins < fullyUpgradedDeltaCoinsCost; // because negative numbers
  }

  @Override
  public void upgrade_lowerTheCost() {
    currentDeltaCoins++; // because negative numbers
  }
}