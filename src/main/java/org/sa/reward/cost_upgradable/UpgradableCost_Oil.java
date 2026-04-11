package org.sa.reward.cost_upgradable;

import org.sa.DTO.PlayerDTO;

public class UpgradableCost_Oil implements UpgradableCost {
  private int currentDeltaOil;
  private int fullyUpgradedDeltaOilCost;

  public UpgradableCost_Oil(int initialDeltaOilCost, int fullyUpgradedDeltaOilCost) {
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
  public int getCurrentChangeDelta() {
    return this.currentDeltaOil;
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
