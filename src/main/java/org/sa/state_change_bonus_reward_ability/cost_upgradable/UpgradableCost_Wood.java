package org.sa.state_change_bonus_reward_ability.cost_upgradable;

import org.sa.DTO.PlayerDTO;
import org.sa.enums.ResourceType;

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
    player.getResourceMap().merge(ResourceType.WOOD, currentDeltaWood, Integer::sum);
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
  }
}