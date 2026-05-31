package org.sa.player_mat.a_top_parts.top_part_upgradable_action;

import org.sa.player_mat.a_top_parts.enums_and_interfaces.TopPartDecision_TYPE_ENUM;
import org.sa.player_mat.a_top_parts.top_part_upgradable_action.interfaces.TopPartUpgradableAction_AppliedByDecision;

public class TopPartUpgradableAction_Produce_Decideable implements TopPartUpgradableAction_AppliedByDecision {
  private int currentLimit_amountOfTilesThatCanProduce;
  private int fullyUpgradedLimit_amountOfTilesThatCanProduce;

  public TopPartUpgradableAction_Produce_Decideable(int currentLimit_amountOfTilesThatCanProduce, int fullyUpgradedLimit_amountOfTilesThatCanProduce) {
    if (currentLimit_amountOfTilesThatCanProduce < 0 || fullyUpgradedLimit_amountOfTilesThatCanProduce < 0)
      throw new IllegalArgumentException("Produce tiles limit should be expressed in positive values");
    this.currentLimit_amountOfTilesThatCanProduce = currentLimit_amountOfTilesThatCanProduce;
    this.fullyUpgradedLimit_amountOfTilesThatCanProduce = fullyUpgradedLimit_amountOfTilesThatCanProduce;
  }

  @Override
  public int getCurrentChangeDelta() {
    return currentLimit_amountOfTilesThatCanProduce;
  }

  @Override
  public boolean canUpgrade() {
    return currentLimit_amountOfTilesThatCanProduce < fullyUpgradedLimit_amountOfTilesThatCanProduce;
  }

  @Override
  public void upgrade_increaseTheReward() {
    currentLimit_amountOfTilesThatCanProduce++;
  }

  @Override
  public TopPartDecision_TYPE_ENUM getDecisionType() {
    return TopPartDecision_TYPE_ENUM.PRODUCE;
  }
}
