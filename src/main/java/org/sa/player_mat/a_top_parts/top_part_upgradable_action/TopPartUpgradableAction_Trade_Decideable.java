package org.sa.player_mat.a_top_parts.top_part_upgradable_action;

import org.sa.player_mat.a_top_parts.enums_and_interfaces.TopPartDecision_TYPE_ENUM;
import org.sa.player_mat.a_top_parts.top_part_upgradable_action.interfaces.TopPartUpgradableAction_AppliedByDecision;

public class TopPartUpgradableAction_Trade_Decideable implements TopPartUpgradableAction_AppliedByDecision {

  // player can get 2 locatable-tradeable resources (same across all player-mats)
  // each locatable-tradeable resource-type is picked independently
  // normally player can choose on any workerTile he can put those new resources - but most of the time player might choose a workerTile with most defencive power
  // if player doesn't have workers place resource on null tile //TODO: can this happen? min amount of 2 workers simply can go back home, and there they can receive the resources, can they?

  @Override
  public int getCurrentChangeDelta() {
    return 2; // can always trade two resources
  }

  @Override
  public boolean canUpgrade() {
    return false;
  }

  @Override
  public void upgrade_increaseTheReward() {
    throw new RuntimeException("trade delta is a constant");
  }

  @Override
  public TopPartDecision_TYPE_ENUM getDecisionType() {
    return TopPartDecision_TYPE_ENUM.TRADE;
  }
}