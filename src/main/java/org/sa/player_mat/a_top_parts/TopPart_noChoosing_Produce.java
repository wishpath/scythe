package org.sa.player_mat.a_top_parts;

import org.sa.placeable.locatable.BuildingType;
import org.sa.player_mat.a_top_parts.enums_and_interfaces.TYPE__TopPart__TopPartChooseActionArray__ActionSpace;
import org.sa.player_mat.a_top_parts.enums_and_interfaces.TopPart;
import org.sa.player_mat.a_top_parts.top_part_cost.TopPartCost;
import org.sa.player_mat.a_top_parts.top_part_upgradable_action.TopPartUpgradableAction_Produce_Decideable;
import org.sa.player_mat.a_top_parts.top_part_upgradable_action.interfaces.TopPartUpgradableAction;
import org.sa.player_mat.a_top_parts.top_part_cost.TopPartCost_Produce;

public class TopPart_noChoosing_Produce implements TopPart {
  private TYPE__TopPart__TopPartChooseActionArray__ActionSpace TOP_PART_TYPE__NO_CHOOSE__PRODUCE = TYPE__TopPart__TopPartChooseActionArray__ActionSpace.NO_CHOOSE__PRODUCE;
  private TopPartCost SPECIAL_PRODUCE_COST = new TopPartCost_Produce();
  private TopPartUpgradableAction[] NO_CHOOSING_SIZE1ARRAY__PRODUCE = new TopPartUpgradableAction[] {
      new TopPartUpgradableAction_Produce_Decideable(2, 3)
  };
  private BuildingType MILL = BuildingType.MILL; // building state stored in playerDTO.isBuilt(type)

  @Override
  public TopPartCost getCost() {
    return this.SPECIAL_PRODUCE_COST;
  }

  @Override
  public TYPE__TopPart__TopPartChooseActionArray__ActionSpace getTopPartType() {
    return this.TOP_PART_TYPE__NO_CHOOSE__PRODUCE;
  }

  @Override
  public BuildingType getBuildingType() {
    return this.MILL;
  }

  @Override
  public TopPartUpgradableAction[] getTopPartChoosableActions() {
    return NO_CHOOSING_SIZE1ARRAY__PRODUCE;
  }
}
