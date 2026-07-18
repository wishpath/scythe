package org.sa.player_mat.bottom_parts.bottom_part_cost;

import org.sa.PlayerDTO;
import org.sa.enums.ResourceType;
import org.sa.player_mat.PlayerMatType;

// for the bottom part of BUILD
public class BottomPartUpgradableCost__Wood implements BottomPartUpgradableCost {
  private int currentDeltaWood;
  private int fullyUpgradedDeltaWoodCost;

  public BottomPartUpgradableCost__Wood(PlayerMatType playerMatType) {
    this.currentDeltaWood = switch (playerMatType) {
      case AGRICULTURAL, INNOVATIVE, MILITANT, PATRIOTIC -> -4;
      case ENGINEERING, INDUSTRIAL, MECHANICAL -> -3;
    };

    this.fullyUpgradedDeltaWoodCost = switch (playerMatType) {
      case MILITANT -> -3;
      case AGRICULTURAL, INDUSTRIAL, MECHANICAL, PATRIOTIC -> -2;
      case INNOVATIVE, ENGINEERING -> -1;
    };

    if (this.currentDeltaWood > this.fullyUpgradedDeltaWoodCost) { //because expressed in negative numbers
      throw new IllegalArgumentException("Upgraded price cannot be higher");
    }
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    if (currentDeltaWood > 0) throw new IllegalArgumentException("Cost should be expressed in negative numbers");
    player.addResource(ResourceType.WOOD, currentDeltaWood);
  }

  @Override
  public int getCurrentChangeDelta() {
    return this.currentDeltaWood;
  }

  @Override
  public boolean canUpgrade() {
    return currentDeltaWood < fullyUpgradedDeltaWoodCost; //because negative numbers
  }

  @Override
  public void upgrade_lowerTheCost() {
    currentDeltaWood++; //because negative numbers

    if (this.currentDeltaWood > this.fullyUpgradedDeltaWoodCost) { //because expressed in negative numbers
      throw new IllegalArgumentException("Upgraded price cannot be higher");
    }
  }
}