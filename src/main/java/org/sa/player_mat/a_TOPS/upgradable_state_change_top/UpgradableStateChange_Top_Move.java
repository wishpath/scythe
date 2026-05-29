package org.sa.player_mat.a_TOPS.upgradable_state_change_top;

import org.sa.player_mat.a_TOPS.enums_and_interfaces.TopStateChangeDecision_TYPE_ENUM;
import org.sa.player_mat.a_TOPS.upgradable_state_change_top.interfaces.UpgradableStateChange_Top_AppliedByDecision;

public class UpgradableStateChange_Top_Move implements UpgradableStateChange_Top_AppliedByDecision {
  private int currentDeltaMove_groupCapacity;
  private int fullyUpgradedDeltaMove_groupCapacity;

  public UpgradableStateChange_Top_Move(int initialDeltaMove_groupCapacity, int fullyUpgradedDeltaMove_groupCapacity) {
    if (initialDeltaMove_groupCapacity < 0 || fullyUpgradedDeltaMove_groupCapacity < 0)
      throw new IllegalArgumentException("Reward should be expressed in positive values");
    this.currentDeltaMove_groupCapacity = initialDeltaMove_groupCapacity;
    this.fullyUpgradedDeltaMove_groupCapacity = fullyUpgradedDeltaMove_groupCapacity;
  }

  @Override
  public int getCurrentChangeDelta() {
    return currentDeltaMove_groupCapacity;
  }

  @Override
  public boolean canUpgrade() {
    return currentDeltaMove_groupCapacity < fullyUpgradedDeltaMove_groupCapacity;
  }

  @Override
  public void upgrade_increaseTheReward() {
    currentDeltaMove_groupCapacity++;
  }

  @Override
  public TopStateChangeDecision_TYPE_ENUM getDecisionType() {
    return TopStateChangeDecision_TYPE_ENUM.MOVE;
  }
}
