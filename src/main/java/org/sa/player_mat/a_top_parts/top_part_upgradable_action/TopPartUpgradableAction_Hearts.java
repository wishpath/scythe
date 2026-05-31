package org.sa.player_mat.a_top_parts.top_part_upgradable_action;

import org.sa.DTO.PlayerDTO;
import org.sa.player_mat.a_top_parts.top_part_upgradable_action.interfaces.TopPartUpgradableAction_ConcreteDeltaType;
import org.sa.player_mat.a_top_parts.enums_and_interfaces.TopPartDecision_TYPE_ENUM;

public class TopPartUpgradableAction_Hearts implements TopPartUpgradableAction_ConcreteDeltaType {
  private int currentDeltaHearts;
  private int fullyUpgradedDeltaHeartsReward;

  public TopPartUpgradableAction_Hearts(int initialDeltaHeartsReward, int fullyUpgradedDeltaHeartsReward) {
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
  public TopPartDecision_TYPE_ENUM getDecisionType() {
    return TopPartDecision_TYPE_ENUM.NONE;
  }
}