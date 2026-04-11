package org.sa.reward.cost_upgradable;

import org.sa.DTO.PlayerDTO;

public class UpgradableCost_Metal implements UpgradableCost {
  private int currentDeltaMetal;
  private int fullyUpgradedDeltaMetalCost;

  public UpgradableCost_Metal(int initialDeltaMetalCost, int fullyUpgradedDeltaMetalCost) {
    if (initialDeltaMetalCost > 0 || fullyUpgradedDeltaMetalCost > 0)
      throw new IllegalArgumentException("Cost should be expressed in negative values");
    this.currentDeltaMetal = initialDeltaMetalCost;
    this.fullyUpgradedDeltaMetalCost = fullyUpgradedDeltaMetalCost;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.metal += currentDeltaMetal;
  }

  @Override
  public int getCurrentChangeDelta() {
    return this.currentDeltaMetal;
  }

  @Override
  public boolean canUpgrade() {
    return currentDeltaMetal < fullyUpgradedDeltaMetalCost; //because negative numbers
  }

  @Override
  public void upgrade_lowerTheCost() {
    currentDeltaMetal++; //because negative numbers
  }
}
