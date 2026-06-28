package org.sa.player_mat.bottom_parts.bottom_part_cost;

import org.sa.DTO.PlayerDTO;
import org.sa.enums.ResourceType;
import org.sa.player_mat.PlayerMat__type_and_structure;

public class BottomPartUpgradableCost__Oil implements BottomPartUpgradableCost {
  private int currentDeltaOil;
  private int fullyUpgradedDeltaOilCost;

  public BottomPartUpgradableCost__Oil(PlayerMat__type_and_structure playerMatType) {
    this.currentDeltaOil = switch (playerMatType) {
      case AGRICULTURAL, PATRIOTIC -> -2;
      case ENGINEERING, INNOVATIVE, INDUSTRIAL, MECHANICAL, MILITANT -> -3;
    };
    this.fullyUpgradedDeltaOilCost = switch (playerMatType) {
      case AGRICULTURAL, ENGINEERING, INDUSTRIAL, MECHANICAL, PATRIOTIC -> -2;
      case INNOVATIVE -> -3;
      case MILITANT -> -1;
    };
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    if (currentDeltaOil > 0) throw new IllegalArgumentException("Cost should be expressed in negative numbers");
    player.getResourceMap().merge(ResourceType.OIL, currentDeltaOil, Integer::sum); //because negative numbers
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
