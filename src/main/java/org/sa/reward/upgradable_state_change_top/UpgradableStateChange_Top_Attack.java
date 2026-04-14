package org.sa.reward.upgradable_state_change_top;

import org.sa.DTO.PlayerDTO;
import org.sa.enums.TopStateChangeDecisionType;

public class UpgradableStateChange_Top_Attack implements UpgradableStateChange_Top {
  private int currentDeltaAttack;
  private int fullyUpgradedDeltaAttackReward;

  public UpgradableStateChange_Top_Attack(int initialDeltaAttackReward, int fullyUpgradedDeltaAttackReward) {
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
  public int getCurrentChangeDelta() {
    return currentDeltaAttack;
  }

  @Override
  public boolean canUpgrade() {
    return currentDeltaAttack < fullyUpgradedDeltaAttackReward;
  }

  @Override
  public void upgrade_increaseTheReward() {
    currentDeltaAttack++;
  }

  @Override
  public TopStateChangeDecisionType getDecisionType() {
    return TopStateChangeDecisionType.NONE;
  }
}