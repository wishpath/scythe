package org.sa.player_mat.bottom_parts.bottom_part_cost;

import org.sa.PlayerDTO;
import org.sa.enums.ResourceType;
import org.sa.player_mat.PlayerMatType;

// for the bottom part of ENLIST
public class BottomPartUpgradableCost__Food implements BottomPartUpgradableCost {
  private int currentDeltaFood;
  private int fullyUpgradedDeltaFoodCost;

  public BottomPartUpgradableCost__Food(PlayerMatType playerMatType) {
    this.currentDeltaFood = switch (playerMatType) {
      case PATRIOTIC, INNOVATIVE, ENGINEERING, AGRICULTURAL, MILITANT -> -3;
      case INDUSTRIAL, MECHANICAL -> -4;
    };

    this.fullyUpgradedDeltaFoodCost = switch (playerMatType) {
      case ENGINEERING, INDUSTRIAL, MECHANICAL, PATRIOTIC -> -2;
      case MILITANT, AGRICULTURAL, INNOVATIVE -> -1;
    };

    if (this.currentDeltaFood > this.fullyUpgradedDeltaFoodCost) { //because expressed in negative numbers
      throw new IllegalArgumentException("Upgraded price cannot be higher");
    }
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    if (currentDeltaFood > 0) throw new IllegalArgumentException("Cost should be expressed in negative numbers");
    player.addResource(ResourceType.FOOD, currentDeltaFood); //current delta is a negative number
  }

  @Override
  public int getCurrentChangeDelta() {
    return this.currentDeltaFood;
  }

  @Override
  public boolean canUpgrade() {
    return currentDeltaFood < fullyUpgradedDeltaFoodCost; //because negative numbers
  }

  @Override
  public void upgrade_lowerTheCost() {
    currentDeltaFood++; //because negative numbers
    if (this.currentDeltaFood > this.fullyUpgradedDeltaFoodCost) { //because expressed in negative numbers
      throw new IllegalArgumentException("Upgraded price cannot be higher");
    }
  }
}