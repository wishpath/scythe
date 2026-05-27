package org.sa.player_mat.a_action_space_TOP.upgradable_state_change_top;

import org.sa.DTO.PlayerDTO;
import org.sa.b_storage.CardPool;
import org.sa.player_mat.x.TopStateChangeDecision_TYPE_ENUM;

public class UpgradableStateChange_Top_AttackCards implements UpgradableStateChange_Top {
  private int currentDeltaCards;
  private int fullyUpgradedDeltaCardsReward;

  public UpgradableStateChange_Top_AttackCards(int initialDeltaCardsReward, int fullyUpgradedDeltaCardsReward) {
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
  public int getCurrentChangeDelta() {
    return currentDeltaCards;
  }

  @Override
  public boolean canUpgrade() {
    return currentDeltaCards < fullyUpgradedDeltaCardsReward;
  }

  @Override
  public void upgrade_increaseTheReward() {
    currentDeltaCards++;
  }

  @Override
  public TopStateChangeDecision_TYPE_ENUM getDecisionType() {
    return TopStateChangeDecision_TYPE_ENUM.NONE;
  }
}