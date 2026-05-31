package org.sa.player_mat.a_top_parts.top_part_upgradable_action;

import org.sa.player_mat.a_top_parts.enums_and_interfaces.TopPartDecision_TYPE_ENUM;
import org.sa.player_mat.a_top_parts.top_part_upgradable_action.interfaces.TopPartUpgradableAction_AppliedByDecision;

public class TopPartUpgradableAction_Move_Decideable implements TopPartUpgradableAction_AppliedByDecision {
  private int currentDeltaMove_groupCapacity;
  private int fullyUpgradedDeltaMove_groupCapacity;

  public TopPartUpgradableAction_Move_Decideable(int initialDeltaMove_groupCapacity, int fullyUpgradedDeltaMove_groupCapacity) {
    if (initialDeltaMove_groupCapacity < 0 || fullyUpgradedDeltaMove_groupCapacity < 0)
      throw new IllegalArgumentException("Move groups should be expressed in positive values");
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
  public TopPartDecision_TYPE_ENUM getDecisionType() {
    return TopPartDecision_TYPE_ENUM.MOVE;
  }
}
