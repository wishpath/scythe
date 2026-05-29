package org.sa.player_mat.a_TOPS.upgradable_state_change_top;

import org.sa.player_mat.a_TOPS.enums_and_interfaces.TopStateChangeDecision_TYPE_ENUM;
import org.sa.player_mat.a_TOPS.upgradable_state_change_top.interfaces.UpgradableStateChange_Top_AppliedByDecision;

public class UpgradableStateChange_Top_Trade implements UpgradableStateChange_Top_AppliedByDecision {
  private int currentDeltaChosenResource;
  private int fullyUpgradedDeltaChosenResult;

  public UpgradableStateChange_Top_Trade(int initialDeltaChosenResourceReward, int fullyUpgradedDeltaChosenResult) {
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
  public TopStateChangeDecision_TYPE_ENUM getDecisionType() {
    return TopStateChangeDecision_TYPE_ENUM.TRADE;
  }
}