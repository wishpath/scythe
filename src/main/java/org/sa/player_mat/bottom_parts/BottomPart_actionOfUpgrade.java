package org.sa.player_mat.bottom_parts;

import org.sa.player_mat.PlayerMat__type_and_structure;
import org.sa.player_mat.a_top_parts.enums_and_interfaces.TYPE__TopPart__TopPartChooseActionArray__ActionSpace;
import org.sa.player_mat.bottom_parts.bottom_part_coin_benefit.BottomPartCoinBenefit;
import org.sa.player_mat.bottom_parts.bottom_part_cost.BottomPartUpgradableCost__Oil;

public class BottomPart_actionOfUpgrade {
  PlayerMat__type_and_structure playerMatType;
  TYPE__BottomPart__BottomPartAction BOTTOM_PART_TYPE__UPGRADE = TYPE__BottomPart__BottomPartAction.UPGRADE;
  TYPE__TopPart__TopPartChooseActionArray__ActionSpace inWhichActionSpaceItComes; //depends on playerMat( and BottomPartType)
  BottomPartUpgradableCost__Oil bottomPartUpgradableCost__oil; //base and delta varies by player mat type so has to be set
  BottomPartCoinBenefit bottomPartCoinBenefit;
  //TODO, only pass PlayerMatTYPE so setable fiels would resolve in their constructors
  BottomPartNeighborTrigger BOTTOM_PART_NEIGHBOR_TRIGGER__UPGRADE = TYPE__BottomPart__BottomPartAction.UPGRADE;
  ResouceType BOTOM_PART_NEIGHBOR_BENNEFIT_TYPE__POWER = ResourceType.POWER; //blend with TradableResourceType in playerDTO, so should also have boolean isTradable
  int BOTOM_PART_NEIGHBOR_BENNEFIT_DELTA__ONE = ResourceType.POWER; //absolutely common in all cases

  public BottomPart_actionOfUpgrade(PlayerMat__type_and_structure playerMatType) {
    this.playerMatType = playerMatType;
    this.bottomPartCoinBenefit = new BottomPartCoinBenefit(BOTTOM_PART_TYPE__UPGRADE, playerMatType);
  }
}
