package org.sa.player_mat.bottom_parts.enums_and_interfaces;

import org.sa.player_mat.PlayerMatType;
import org.sa.player_mat.bottom_parts.bottom_part_coin_benefit.BottomPartCoinBenefit;
import org.sa.player_mat.bottom_parts.bottom_part_cost.BottomPartUpgradableCost;

public interface BottomPart {
  //types
  public PlayerMatType getPlayerMatType();
  public BottomPartType getBottomPartType();

  //state changes
  public BottomPartUpgradableCost getBottomPart_UpgradableCost();
  public BottomPartCoinBenefit getBottomPartCoinBenefit();
}
