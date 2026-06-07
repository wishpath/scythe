package org.sa.state_change_bonus_reward_ability.cost_upgradable;

import org.sa.DTO.PlayerDTO;
import org.sa.enums.ResourceType;

public class UpgradableCost_Oil implements UpgradableCost {
  private int currentDeltaOil;
  private int fullyUpgradedDeltaOilCost;

  public UpgradableCost_Oil(int initialDeltaOilCost, int fullyUpgradedDeltaOilCost) {
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
