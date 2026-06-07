package org.sa.state_change_bonus_reward_ability.cost_upgradable;

import org.sa.DTO.PlayerDTO;
import org.sa.enums.ResourceType;

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
    player.getResourceMap().merge(ResourceType.METAL, currentDeltaMetal, Integer::sum);
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
