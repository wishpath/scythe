package org.sa.player_mat.a_top_parts.top_part_upgradable_action;

import org.sa.DTO.PlayerDTO;
import org.sa.enums.ResourceType;
import org.sa.player_mat.a_top_parts.enums_and_interfaces.TopPartDecision_TYPE_ENUM;
import org.sa.player_mat.a_top_parts.top_part_upgradable_action.interfaces.TopPartUpgradableAction_ConcreteDeltaType;

public class TopPartUpgradableAction_AttackCards implements TopPartUpgradableAction_ConcreteDeltaType {
  private int currentDeltaCards;
  private int fullyUpgradedDeltaCardsReward;

  public TopPartUpgradableAction_AttackCards(int initialDeltaCardsReward, int fullyUpgradedDeltaCardsReward) {
    if (initialDeltaCardsReward < 0 || fullyUpgradedDeltaCardsReward < 0)
      throw new IllegalArgumentException("Reward should be expressed in positive values");
    this.currentDeltaCards = initialDeltaCardsReward;
    this.fullyUpgradedDeltaCardsReward = fullyUpgradedDeltaCardsReward;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.addResource(ResourceType.COMBAT_CARDS, currentDeltaCards);
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
  public TopPartDecision_TYPE_ENUM getDecisionType() {
    return TopPartDecision_TYPE_ENUM.NONE;
  }
}