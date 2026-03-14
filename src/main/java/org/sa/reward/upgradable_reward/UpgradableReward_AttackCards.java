package org.sa.reward.upgradable_reward;

import org.sa.DTO.PlayerDTO;
import org.sa.b_storage.CardPool;

public class UpgradableReward_AttackCards implements UpgradableReward {
  private int currentDeltaCards;
  private int fullyUpgradedDeltaCardsReward;

  public UpgradableReward_AttackCards(int initialDeltaCardsReward, int fullyUpgradedDeltaCardsReward) {
    if (initialDeltaCardsReward < 0 || fullyUpgradedDeltaCardsReward < 0)
      throw new IllegalArgumentException("Reward should be expressed in positive values");
    this.currentDeltaCards = initialDeltaCardsReward;
    this.fullyUpgradedDeltaCardsReward = fullyUpgradedDeltaCardsReward;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    for (int i = 0; i < currentDeltaCards; i++)
      player.attackCards.add(CardPool.drawAttackCard());
  }

  @Override
  public boolean canUpgrade() {
    return currentDeltaCards < fullyUpgradedDeltaCardsReward;
  }

  @Override
  public void upgrade_increaseTheReward() {
    currentDeltaCards++;
  }
}