package org.sa.reward.cost_upgradable;

import org.sa.DTO.PlayerDTO;

public class UpgradableCost_Wood implements UpgradableCost {
  private int currentDeltaWood;
  private int fullyUpgradedDeltaWoodCost;

  public UpgradableCost_Wood(int initialDeltaWoodCost, int fullyUpgradedDeltaWoodCost) {
    if (initialDeltaWoodCost > 0 || fullyUpgradedDeltaWoodCost > 0)
      throw new IllegalArgumentException("Cost should be expressed in negative values");
    this.currentDeltaWood = initialDeltaWoodCost;
    this.fullyUpgradedDeltaWoodCost = fullyUpgradedDeltaWoodCost;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.wood += currentDeltaWood;
  }

  @Override
  public boolean canUpgrade() {
    return currentDeltaWood < fullyUpgradedDeltaWoodCost; //because negative numbers
  }

  @Override
  public void upgrade_lowerTheCost() {
    currentDeltaWood++; //because negative numbers
  }
}