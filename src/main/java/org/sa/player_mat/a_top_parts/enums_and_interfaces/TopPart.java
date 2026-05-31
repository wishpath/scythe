package org.sa.player_mat.a_top_parts.enums_and_interfaces;

import org.sa.enums.BuildingType;
import org.sa.player_mat.a_top_parts.top_part_cost.TopPartCost;
import org.sa.player_mat.a_top_parts.top_part_upgradable_action.interfaces.TopPartUpgradableAction;

public interface TopPart {
  public TopPartCost getCost();
  public TYPE__TopPart__TopPartChooseActionArray__ActionSpace getTopPartType();
  public BuildingType getBuildingType();
  public TopPartUpgradableAction[] getTopPartChoosableActions();
}
