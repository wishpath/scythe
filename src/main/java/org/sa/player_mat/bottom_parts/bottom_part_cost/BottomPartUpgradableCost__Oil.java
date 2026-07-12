package org.sa.player_mat.bottom_parts.bottom_part_cost;

import org.sa.DTO.PlayerDTO;
import org.sa.enums.ResourceType;
import org.sa.player_mat.PlayerMatType;

// for the bottom part of UPGRADE
public class BottomPartUpgradableCost__Oil implements BottomPartUpgradableCost {
  private int currentDeltaOil;
  private int fullyUpgradedDeltaOilCost;

  public BottomPartUpgradableCost__Oil(PlayerMatType playerMatType) {
    this.currentDeltaOil = switch (playerMatType) {
      case AGRICULTURAL, PATRIOTIC -> -2;
      case ENGINEERING, INNOVATIVE, INDUSTRIAL, MECHANICAL, MILITANT -> -3;
    };

    this.fullyUpgradedDeltaOilCost = switch (playerMatType) {
      case AGRICULTURAL, ENGINEERING, INDUSTRIAL, MECHANICAL, PATRIOTIC -> -2;
      case INNOVATIVE -> -3;
      case MILITANT -> -1;
    };

    if (this.currentDeltaOil > this.fullyUpgradedDeltaOilCost) { //because expressed in negative numbers
      throw new IllegalArgumentException("Upgraded price cannot be higher");
    }
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    if (currentDeltaOil > 0) throw new IllegalArgumentException("Cost should be expressed in negative numbers");
    player.addResource(ResourceType.OIL, currentDeltaOil);
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

    if (this.currentDeltaOil > this.fullyUpgradedDeltaOilCost) { //because expressed in negative numbers
      throw new IllegalArgumentException("Upgraded price cannot be higher");
    }
  }
}
