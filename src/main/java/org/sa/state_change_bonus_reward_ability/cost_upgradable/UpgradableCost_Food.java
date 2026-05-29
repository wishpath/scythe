package org.sa.state_change_bonus_reward_ability.cost_upgradable;

import org.sa.DTO.PlayerDTO;
import org.sa.enums.TradeableResourceType;

public class UpgradableCost_Food implements UpgradableCost {
  private int currentDeltaFood;
  private int fullyUpgradedDeltaFoodCost;

  public UpgradableCost_Food(int initialDeltaFoodCost, int fullyUpgradedDeltaFoodCost) {
    if (initialDeltaFoodCost > 0 || fullyUpgradedDeltaFoodCost > 0)
      throw new IllegalArgumentException("Cost should be expressed in negative values");
    this.currentDeltaFood = initialDeltaFoodCost;
    this.fullyUpgradedDeltaFoodCost = fullyUpgradedDeltaFoodCost;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.tradeableResourceInventory.merge(TradeableResourceType.FOOD, currentDeltaFood, Integer::sum);
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
  }
}