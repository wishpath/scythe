package org.sa.player_mat.a_TOPS.upgradable_state_change_top;

import org.sa.player_mat.a_TOPS.enums_and_interfaces.TopStateChangeDecision_TYPE_ENUM;
import org.sa.player_mat.a_TOPS.upgradable_state_change_top.interfaces.UpgradableStateChange_Top_AppliedByDecision;

public class UpgradableStateChange_Top_Produce_Decideable implements UpgradableStateChange_Top_AppliedByDecision {
  private int currentLimit_amountOfTilesThatCanProduce;
  private int fullyUpgradedLimit_amountOfTilesThatCanProduce;

  public UpgradableStateChange_Top_Produce_Decideable(int currentLimit_amountOfTilesThatCanProduce, int fullyUpgradedLimit_amountOfTilesThatCanProduce) {
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
  public TopStateChangeDecision_TYPE_ENUM getDecisionType() {
    return TopStateChangeDecision_TYPE_ENUM.PRODUCE;
  }
}
