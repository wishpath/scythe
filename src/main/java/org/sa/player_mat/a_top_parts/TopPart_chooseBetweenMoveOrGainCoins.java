package org.sa.player_mat.a_top_parts;

import org.sa.placeable.locatable.BuildingType;
import org.sa.player_mat.a_top_parts.enums_and_interfaces.TYPE__TopPart__TopPartChooseActionArray__ActionSpace;
import org.sa.player_mat.a_top_parts.enums_and_interfaces.TopPart;
import org.sa.player_mat.a_top_parts.top_part_cost.TopPartCost;
import org.sa.player_mat.a_top_parts.top_part_cost.TopPartCost_0_free;
import org.sa.player_mat.a_top_parts.top_part_upgradable_action.TopPartUpgradableAction_Move_Decideable;
import org.sa.player_mat.a_top_parts.top_part_upgradable_action.TopPartUpgradableAction_Reward_Coins;
import org.sa.player_mat.a_top_parts.top_part_upgradable_action.interfaces.TopPartUpgradableAction;

public class TopPart_chooseBetweenMoveOrGainCoins implements TopPart {

  private TYPE__TopPart__TopPartChooseActionArray__ActionSpace TOP_PART_TYPE__CHOOSE__MOVE__GAIN_COINS = TYPE__TopPart__TopPartChooseActionArray__ActionSpace.CHOOSE__MOVE__GAIN_COINS;
  private TopPartCost FREE = new TopPartCost_0_free();
  private TopPartUpgradableAction[] CHOOSE_BETWEEN_MOVE_OR_GAIN_COINS = new TopPartUpgradableAction[] {
      new TopPartUpgradableAction_Move_Decideable(2, 3),
      new TopPartUpgradableAction_Reward_Coins(1, 2)
  };
  private BuildingType MINE = BuildingType.MINE; // building state stored in playerDTO.isBuilt(type)

  /** There's no constructor because all player mats have exactly same structure for this top part */
  @Override
  public TopPartCost getCost() {
    return this.FREE;
  }

  @Override
  public TYPE__TopPart__TopPartChooseActionArray__ActionSpace getTopPartType() {
    return this.TOP_PART_TYPE__CHOOSE__MOVE__GAIN_COINS;
  }

  @Override
  public BuildingType getBuildingType() {
    return this.MINE;
  }

  @Override
  public TopPartUpgradableAction[] getTopPartChoosableActions() {
    return CHOOSE_BETWEEN_MOVE_OR_GAIN_COINS;
  }
}
