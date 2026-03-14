package org.sa.reward.upgradable_reward;

import org.sa.DTO.PlayerDTO;

public class UpgradableReward_Attack implements UpgradableReward {
  private int currentDeltaAttack;
  private int fullyUpgradedDeltaAttackReward;

  public UpgradableReward_Attack(int initialDeltaAttackReward, int fullyUpgradedDeltaAttackReward) {
    if (initialDeltaAttackReward < 0 || fullyUpgradedDeltaAttackReward < 0)
      throw new IllegalArgumentException("Reward should be expressed in positive values");
    this.currentDeltaAttack = initialDeltaAttackReward;
    this.fullyUpgradedDeltaAttackReward = fullyUpgradedDeltaAttackReward;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.attack += currentDeltaAttack;
  }

  @Override
  public boolean canUpgrade() {
    return currentDeltaAttack < fullyUpgradedDeltaAttackReward;
  }

  @Override
  public void upgrade_increaseTheReward() {
    currentDeltaAttack++;
  }
}