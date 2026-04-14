package org.sa.reward.upgradable_state_change_top;

import org.sa.DTO.PlayerDTO;
import org.sa.enums.TopStateChangeDecisionType;

public class UpgradableStateChange_Top_Hearts implements UpgradableStateChange_Top {
  private int currentDeltaHearts;
  private int fullyUpgradedDeltaHeartsReward;

  public UpgradableStateChange_Top_Hearts(int initialDeltaHeartsReward, int fullyUpgradedDeltaHeartsReward) {
    if (initialDeltaHeartsReward < 0 || fullyUpgradedDeltaHeartsReward < 0)
      throw new IllegalArgumentException("Reward should be expressed in positive values");
    this.currentDeltaHearts = initialDeltaHeartsReward;
    this.fullyUpgradedDeltaHeartsReward = fullyUpgradedDeltaHeartsReward;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.hearts += currentDeltaHearts;
  }

  @Override
  public int getCurrentChangeDelta() {
    return currentDeltaHearts;
  }

  @Override
  public boolean canUpgrade() {
    return currentDeltaHearts < fullyUpgradedDeltaHeartsReward;
  }

  @Override
  public void upgrade_increaseTheReward() {
    currentDeltaHearts++;
  }

  @Override
  public TopStateChangeDecisionType getDecisionType() {
    return TopStateChangeDecisionType.NONE;
  }
}