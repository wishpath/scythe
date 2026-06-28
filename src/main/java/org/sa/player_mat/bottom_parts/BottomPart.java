package org.sa.player_mat.bottom_parts;

import org.sa.enums.ResourceType;
import org.sa.player_mat.PlayerMat__type_and_structure;
import org.sa.player_mat.bottom_parts.bottom_part_coin_benefit.BottomPartCoinBenefit;
import org.sa.player_mat.bottom_parts.bottom_part_cost.BottomPartUpgradableCost;

public interface BottomPart {
  //types
  public PlayerMat__type_and_structure getPlayerMatType();
  public TYPE__BottomPart__BottomPartAction getBottomPartType();

  //state changes
  public BottomPartUpgradableCost getBottomPart_UpgradableCost();
  public BottomPartCoinBenefit getBottomPartCoinBenefit();

  // neighbor bonus
  public TYPE__BottomPart__BottomPartAction getType_NeighborTrigger();
  public ResourceType getType_NeighborBenefit();
  public int getDelta_NeighborBenefit_ONE();
}
