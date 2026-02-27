package org.sa.reward.reward_enlistable;

import org.sa.DTO.PlayerDTO;

public class UpgradableCost_Food implements UpgradableCost {
  private int currentDeltaFood;
  private int fullyUpgradedDeltaFoodCost;

  public UpgradableCost_Food(int initialDeltaFoodCost, int fullyUpgradedDeltaFoodCost) {
    if (initialDeltaFoodCost > 0 || fullyUpgradedDeltaFoodCost > 0)
      throw new IllegalArgumentException("Cost should be expressed in negative values");
    this.currentDeltaFood = initialDeltaFoodCost;
    this.fullyUpgradedDeltaFoodCost = fullyUpgradedDeltaFoodCost;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.food += currentDeltaFood;
  }

  @Override
  public boolean canUpgrade() {
    return currentDeltaFood < fullyUpgradedDeltaFoodCost; //because negative numbers
  }

  @Override
  public void upgrade_lowerTheCost() {
    currentDeltaFood++; //because negative numbers
  }
}