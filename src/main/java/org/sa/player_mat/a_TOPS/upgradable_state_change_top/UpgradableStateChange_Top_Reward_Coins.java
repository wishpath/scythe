package org.sa.player_mat.a_TOPS.upgradable_state_change_top;

import org.sa.DTO.PlayerDTO;
import org.sa.player_mat.a_TOPS.upgradable_state_change_top.interfaces.UpgradableStateChange_Top_ConcreteDeltaType;
import org.sa.player_mat.a_TOPS.enums_and_interfaces.TopStateChangeDecision_TYPE_ENUM;

public class UpgradableStateChange_Top_Reward_Coins implements UpgradableStateChange_Top_ConcreteDeltaType {
  private int currentDeltaCoins;
  private int fullyUpgradedDeltaCoinsReward;

  public UpgradableStateChange_Top_Reward_Coins(int initialDeltaCoinsReward, int fullyUpgradedDeltaCoinsReward) {
    if (initialDeltaCoinsReward < 0 || fullyUpgradedDeltaCoinsReward < 0)
      throw new IllegalArgumentException("Reward should be expressed in positive values");
    this.currentDeltaCoins = initialDeltaCoinsReward;
    this.fullyUpgradedDeltaCoinsReward = fullyUpgradedDeltaCoinsReward;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.coins += currentDeltaCoins;
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
  public TopStateChangeDecision_TYPE_ENUM getDecisionType() {
    return TopStateChangeDecision_TYPE_ENUM.NONE;
  }
}