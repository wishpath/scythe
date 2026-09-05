package org.sa.player_mat.a_top_parts;

import org.sa.PlayerDTO;
import org.sa.enums.IntResourceType;
import org.sa.locatable.locatable.BuildingType;
import org.sa.player_mat.a_top_parts.enums_and_interfaces.TYPE_TopPart_ActionSpace;
import org.sa.player_mat.a_top_parts.enums_and_interfaces.TopPart;
import org.sa.player_mat.a_top_parts.top_part_cost.TopPartCost;
import org.sa.player_mat.a_top_parts.top_part_cost.TopPartCost_Minus1Coin;
import org.sa.player_mat.a_top_parts.top_part_upgradable_action.TopPartUpgradableAction_Attack;
import org.sa.player_mat.a_top_parts.top_part_upgradable_action.TopPartUpgradableAction_AttackCards;
import org.sa.player_mat.a_top_parts.top_part_upgradable_action.interfaces.TopPartUpgradableAction;

public class TopPart_chooseBetweenAttack_PointsOrCards implements TopPart {
  private TYPE_TopPart_ActionSpace TOP_PART_TYPE = TYPE_TopPart_ActionSpace.CHOOSE__POWER__COMBAT_CARDS;
  private TopPartCost MINUS_ONE_COIN = new TopPartCost_Minus1Coin();
  private TopPartUpgradableAction[] CHOOSE_BETWEEN_POWER_OR_COMBAT_CARDS = new TopPartUpgradableAction[] {
    new TopPartUpgradableAction_Attack(2,3),
    new TopPartUpgradableAction_AttackCards(1, 2)
  };
  private BuildingType type_MONUMENT = BuildingType.MONUMENT; // building state stored in playerDTO.isBuilt(type)

  @Override
  public TopPartCost getCost() {
    return this.MINUS_ONE_COIN;
  }

  @Override
  public void payForTopPart(PlayerDTO player) {
    this.MINUS_ONE_COIN.applyToPlayer(player);
  }

  @Override
  public TYPE_TopPart_ActionSpace getTopPartType() {
    return this.TOP_PART_TYPE;
  }

  @Override
  public BuildingType getBuildingType() {
    return this.type_MONUMENT;
  }

  @Override
  public TopPartUpgradableAction[] getTopPartChoosableActions() {
    return CHOOSE_BETWEEN_POWER_OR_COMBAT_CARDS;
  }

  @Override
  public void rewardPlayerWithBuildingRelatedIntResourceIfApplicable(PlayerDTO player) {
    if (player.isBuilt(this.type_MONUMENT)) player.deltaIntResource(IntResourceType.HEARTS, 1);
  }
}
