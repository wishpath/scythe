package org.sa.reward;

import org.sa.DTO.PlayerDTO;

public class Cost_Upgradable_Oil implements UpgradableReward {
  private int currentDeltaOil;
  private int minDeltaOil;

  public Cost_Upgradable_Oil(int initialDeltaOilCost, int minDeltaOilCost) {
    if (initialDeltaOilCost > 0 || minDeltaOilCost > 0)
      throw new IllegalArgumentException("Cost should be expressed in negative values");
    this.currentDeltaOil = initialDeltaOilCost;
    this.minDeltaOil = minDeltaOilCost;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.oil += currentDeltaOil;
  }

  @Override
  public boolean canUpgrade() {
    return currentDeltaOil < minDeltaOil;
  }

  @Override
  public void upgrade_lowerCost() {
    currentDeltaOil++;
  }
}
