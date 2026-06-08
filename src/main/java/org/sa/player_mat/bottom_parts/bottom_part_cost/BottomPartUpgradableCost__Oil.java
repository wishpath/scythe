package org.sa.player_mat.bottom_parts.bottom_part_cost;

import org.sa.DTO.PlayerDTO;
import org.sa.enums.ResourceType;
import org.sa.player_mat.PlayerMat__type_and_structure;

public class BottomPartUpgradableCost__Oil implements BottomPartUpgradableCost {
  private int currentDeltaOil;
  private int fullyUpgradedDeltaOilCost;

  public BottomPartUpgradableCost__Oil(int initialDeltaOilCost, int fullyUpgradedDeltaOilCost) {
    if (initialDeltaOilCost > 0 || fullyUpgradedDeltaOilCost > 0)
      throw new IllegalArgumentException("Cost should be expressed in negative values");
    this.currentDeltaOil = initialDeltaOilCost;
    this.fullyUpgradedDeltaOilCost = fullyUpgradedDeltaOilCost;
  }

  public BottomPartUpgradableCost__Oil(PlayerMat__type_and_structure playerMatType) {
    this.currentDeltaOil = switch (playerMatType) {
      case AGRICULTURAL -> -2;
      case ENGINEERING -> -3;
      case INNOVATIVE -> -3;
      case INDUSTRIAL -> -3;
      case MECHANICAL -> -3;
      case MILITANT -> -3;
      case PATRIOTIC -> -2;
    };
    this.fullyUpgradedDeltaOilCost = switch (playerMatType) {
      case AGRICULTURAL -> -2;
      case ENGINEERING -> -2;
      case INNOVATIVE -> -3;
      case INDUSTRIAL -> -2;
      case MECHANICAL -> -2;
      case MILITANT -> -1;
      case PATRIOTIC -> -2;
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
