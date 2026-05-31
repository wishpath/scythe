package org.sa.player_mat.a_top_parts.top_part_upgradable_action;

import org.sa.player_mat.a_top_parts.enums_and_interfaces.TopPartDecision_TYPE_ENUM;
import org.sa.player_mat.a_top_parts.top_part_upgradable_action.interfaces.TopPartUpgradableAction_AppliedByDecision;

public class TopPartUpgradableAction_Trade_Decideable implements TopPartUpgradableAction_AppliedByDecision {
  private int currentDeltaChosenResource;
  private int fullyUpgradedDeltaChosenResult;

  public TopPartUpgradableAction_Trade_Decideable(int initialDeltaChosenResourceReward, int fullyUpgradedDeltaChosenResult) {
    if (initialDeltaChosenResourceReward < 0 || fullyUpgradedDeltaChosenResult < 0)
      throw new IllegalArgumentException("Reward should be expressed in positive values");
    this.currentDeltaChosenResource = initialDeltaChosenResourceReward;
    this.fullyUpgradedDeltaChosenResult = fullyUpgradedDeltaChosenResult;
  }

  @Override
  public int getCurrentChangeDelta() {
    return currentDeltaChosenResource;
  }

  @Override
  public boolean canUpgrade() {
    return currentDeltaChosenResource < fullyUpgradedDeltaChosenResult;
  }

  @Override
  public void upgrade_increaseTheReward() {
    currentDeltaChosenResource++;
  }

  @Override
  public TopPartDecision_TYPE_ENUM getDecisionType() {
    return TopPartDecision_TYPE_ENUM.TRADE;
  }
}