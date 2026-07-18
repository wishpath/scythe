package org.sa.player_mat.a_top_parts.top_part_upgradable_action;

import org.sa.PlayerDTO;
import org.sa.enums.ResourceType;
import org.sa.player_mat.a_top_parts.top_part_upgradable_action.interfaces.TopPartUpgradableAction_ConcreteDeltaType;
import org.sa.player_mat.a_top_parts.enums_and_interfaces.TopPartDecision_TYPE_ENUM;

public class TopPartUpgradableAction_Reward_Coins implements TopPartUpgradableAction_ConcreteDeltaType {
  private int currentDeltaCoins;
  private int fullyUpgradedDeltaCoinsReward;

  public TopPartUpgradableAction_Reward_Coins(int initialDeltaCoinsReward, int fullyUpgradedDeltaCoinsReward) {
    if (initialDeltaCoinsReward < 0 || fullyUpgradedDeltaCoinsReward < 0)
      throw new IllegalArgumentException("Reward should be expressed in positive values");
    this.currentDeltaCoins = initialDeltaCoinsReward;
    this.fullyUpgradedDeltaCoinsReward = fullyUpgradedDeltaCoinsReward;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.addResource(ResourceType.COINS, currentDeltaCoins);
  }

  @Override
  public int getCurrentChangeDelta() {
    return currentDeltaCoins;
  }

  @Override
  public boolean canUpgrade() {
    return currentDeltaCoins < fullyUpgradedDeltaCoinsReward;
  }

  @Override
  public void upgrade_increaseTheReward() {
    currentDeltaCoins++;
  }

  @Override
  public TopPartDecision_TYPE_ENUM getDecisionType() {
    return TopPartDecision_TYPE_ENUM.NONE;
  }
}