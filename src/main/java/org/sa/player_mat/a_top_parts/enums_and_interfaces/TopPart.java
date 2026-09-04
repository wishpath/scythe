package org.sa.player_mat.a_top_parts.enums_and_interfaces;

import org.sa.PlayerDTO;
import org.sa.locatable.locatable.BuildingType;
import org.sa.player_mat.a_top_parts.top_part_cost.TopPartCost;
import org.sa.player_mat.a_top_parts.top_part_upgradable_action.interfaces.TopPartUpgradableAction;

public interface TopPart {
  TopPartCost getCost();
  TYPE_TopPart_ActionSpace getTopPartType();
  BuildingType getBuildingType();
  TopPartUpgradableAction[] getTopPartChoosableActions();
  void rewardPlayerWithBuildingRelatedIntResourceIfApplicable(PlayerDTO player);
}
