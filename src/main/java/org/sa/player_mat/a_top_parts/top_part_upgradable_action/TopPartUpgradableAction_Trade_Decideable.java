package org.sa.player_mat.a_top_parts.top_part_upgradable_action;

import org.sa.player_mat.a_top_parts.enums_and_interfaces.TopPartDecision_TYPE_ENUM;
import org.sa.player_mat.a_top_parts.top_part_upgradable_action.interfaces.TopPartUpgradableAction_AppliedByDecision;

public class TopPartUpgradableAction_Trade_Decideable implements TopPartUpgradableAction_AppliedByDecision {
  private final int currentDeltaChosenResource_TWO = 2;
  private final int fullyUpgradedDeltaChosenResult_TWO = 2;

  public TopPartUpgradableAction_Trade_Decideable() {
    if (currentDeltaChosenResource_TWO < 0 || fullyUpgradedDeltaChosenResult_TWO < 0)
      throw new IllegalArgumentException("Reward should be expressed in positive values");
  }

  @Override
  public int getCurrentChangeDelta() {
    return currentDeltaChosenResource_TWO;
  }

  @Override
  public boolean canUpgrade() {
    return false;
  }

  @Override
  public void upgrade_increaseTheReward() {
    throw new RuntimeException("trade delta is a constant");
  }

  @Override
  public TopPartDecision_TYPE_ENUM getDecisionType() {
    return TopPartDecision_TYPE_ENUM.TRADE;
  }
}