package org.sa.player_mat.a_top_parts.top_part_upgradable_action;

import org.sa.DTO.PlayerDTO;
import org.sa.enums.ResourceType;
import org.sa.player_mat.a_top_parts.top_part_upgradable_action.interfaces.TopPartUpgradableAction_ConcreteDeltaType;
import org.sa.player_mat.a_top_parts.enums_and_interfaces.TopPartDecision_TYPE_ENUM;

public class TopPartUpgradableAction_Attack implements TopPartUpgradableAction_ConcreteDeltaType {
  private int currentDeltaAttack;
  private int fullyUpgradedDeltaAttackReward;

  public TopPartUpgradableAction_Attack(int initialDeltaAttackReward, int fullyUpgradedDeltaAttackReward) {
    if (initialDeltaAttackReward < 0 || fullyUpgradedDeltaAttackReward < 0)
      throw new IllegalArgumentException("Reward should be expressed in positive values");
    this.currentDeltaAttack = initialDeltaAttackReward;
    this.fullyUpgradedDeltaAttackReward = fullyUpgradedDeltaAttackReward;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.addResource(ResourceType.ATTACK, currentDeltaAttack);
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
  public TopPartDecision_TYPE_ENUM getDecisionType() {
    return TopPartDecision_TYPE_ENUM.NONE;
  }
}