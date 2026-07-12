package org.sa.player_mat.bottom_parts.bottom_part_cost;

import org.sa.DTO.PlayerDTO;
import org.sa.enums.ResourceType;
import org.sa.player_mat.PlayerMatType;

// for the bottom part of DEPLOY
public class BottomPartUpgradableCost__Metal implements BottomPartUpgradableCost {
  private int currentDeltaMetal;
  private int fullyUpgradedDeltaMetalCost;

  public BottomPartUpgradableCost__Metal(PlayerMatType playerMatType) {
    this.currentDeltaMetal = switch (playerMatType) {
      case AGRICULTURAL, ENGINEERING, PATRIOTIC -> -4;
      case INDUSTRIAL, INNOVATIVE, MECHANICAL, MILITANT -> -3;
    };

    this.fullyUpgradedDeltaMetalCost = switch (playerMatType) {
      case AGRICULTURAL, INNOVATIVE, ENGINEERING, MILITANT  -> -2;
      case MECHANICAL, INDUSTRIAL, PATRIOTIC -> -1;
    };

    if (this.currentDeltaMetal > this.fullyUpgradedDeltaMetalCost) { //because expressed in negative numbers
      throw new IllegalArgumentException("Upgraded price cannot be higher");
    }
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    if (currentDeltaMetal > 0) throw new IllegalArgumentException("Cost should be expressed in negative numbers");
    player.addResource(ResourceType.METAL, currentDeltaMetal); //currentDeltaMetal is a negative number
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
    if (this.currentDeltaMetal > this.fullyUpgradedDeltaMetalCost) { //because expressed in negative numbers
      throw new IllegalArgumentException("Upgraded price cannot be higher");
    }
  }
}
