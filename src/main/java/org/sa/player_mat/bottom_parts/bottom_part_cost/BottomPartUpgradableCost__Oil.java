package org.sa.player_mat.bottom_parts.bottom_part_cost;

import org.sa.DTO.PlayerDTO;
import org.sa.enums.ResourceType;

public class BottomPartUpgradableCost__Oil implements BottomPartUpgradableCost {
  private int currentDeltaOil;
  private int fullyUpgradedDeltaOilCost;

  public BottomPartUpgradableCost__Oil(int initialDeltaOilCost, int fullyUpgradedDeltaOilCost) {
    if (initialDeltaOilCost > 0 || fullyUpgradedDeltaOilCost > 0)
      throw new IllegalArgumentException("Cost should be expressed in negative values");
    this.currentDeltaOil = initialDeltaOilCost;
    this.fullyUpgradedDeltaOilCost = fullyUpgradedDeltaOilCost;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.getResourceMap().merge(ResourceType.OIL, currentDeltaOil, Integer::sum);
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
