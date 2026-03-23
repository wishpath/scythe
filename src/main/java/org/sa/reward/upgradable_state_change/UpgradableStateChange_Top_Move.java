package org.sa.reward.upgradable_state_change;

import org.sa.DTO.PlayerDTO;
import org.sa.enums.TopStateChangeDecisionType;

public class UpgradableStateChange_Top_Move implements UpgradableStateChange_Top {
  private int currentDeltaMove_groupCapacity;
  private int fullyUpgradedDeltaMove_groupCapacity;

  public UpgradableStateChange_Top_Move(int initialDeltaMove_groupCapacity, int fullyUpgradedDeltaMove_groupCapacity) {
    if (initialDeltaMove_groupCapacity < 0 || fullyUpgradedDeltaMove_groupCapacity < 0)
      throw new IllegalArgumentException("Reward should be expressed in positive values");
    this.currentDeltaMove_groupCapacity = initialDeltaMove_groupCapacity;
    this.fullyUpgradedDeltaMove_groupCapacity = fullyUpgradedDeltaMove_groupCapacity;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    // TODO: implement move reward logic: player class should have knowledge, what has to be moved and where
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
  public TopStateChangeDecisionType getDecisionType() {
    return TopStateChangeDecisionType.MOVE;
  }
}
