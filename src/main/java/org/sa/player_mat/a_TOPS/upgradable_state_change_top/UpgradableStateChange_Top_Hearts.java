package org.sa.player_mat.a_TOPS.upgradable_state_change_top;

import org.sa.DTO.PlayerDTO;
import org.sa.player_mat.a_TOPS.upgradable_state_change_top.interfaces.UpgradableStateChange_Top_ConcreteDeltaType;
import org.sa.player_mat.a_TOPS.enums_and_interfaces.TopStateChangeDecision_TYPE_ENUM;

public class UpgradableStateChange_Top_Hearts implements UpgradableStateChange_Top_ConcreteDeltaType {
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
  public TopStateChangeDecision_TYPE_ENUM getDecisionType() {
    return TopStateChangeDecision_TYPE_ENUM.NONE;
  }
}