package org.sa.reward;

import org.sa.DTO.PlayerDTO;

public class Cost_Upgradable_Oil implements UpgradableReward {
  private int currentDeltaOil;
  private int fullyUpgradedDeltaOilCost;

  public Cost_Upgradable_Oil(int initialDeltaOilCost, int fullyUpgradedDeltaOilCost) {
    if (initialDeltaOilCost > 0 || fullyUpgradedDeltaOilCost > 0)
      throw new IllegalArgumentException("Cost should be expressed in negative values");
    this.currentDeltaOil = initialDeltaOilCost;
    this.fullyUpgradedDeltaOilCost = fullyUpgradedDeltaOilCost;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.oil += currentDeltaOil;
  }

  @Override
  public boolean canUpgrade() {
    return currentDeltaOil < fullyUpgradedDeltaOilCost; //because negative numbers
  }

  @Override
  public void upgrade_lowerTheCost() {
    currentDeltaOil++; //because negative numbers
  }
}
