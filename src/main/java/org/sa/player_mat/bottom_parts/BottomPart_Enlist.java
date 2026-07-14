package org.sa.player_mat.bottom_parts;

import org.sa.player_mat.PlayerMatType;
import org.sa.player_mat.bottom_parts.bottom_part_coin_benefit.BottomPartCoinBenefit;
import org.sa.player_mat.bottom_parts.bottom_part_cost.BottomPartUpgradableCost;
import org.sa.player_mat.bottom_parts.bottom_part_cost.BottomPartUpgradableCost__Food;
import org.sa.player_mat.bottom_parts.enums_and_interfaces.BottomPart;
import org.sa.player_mat.bottom_parts.enums_and_interfaces.BottomPartType;

public class BottomPart_Enlist implements BottomPart {

  // types
  public PlayerMatType playerMatType; //example AGRICULTURAL
  public BottomPartType BOTTOM_PART_TYPE__ENLIST = BottomPartType.ENLIST;

  // state changes
  public BottomPartUpgradableCost__Food bottomPartUpgradableCost__food;
  public BottomPartCoinBenefit bottomPartCoinBenefit;

  /** constructor */
  public BottomPart_Enlist(PlayerMatType playerMatType) {
    this.playerMatType = playerMatType;
    this.bottomPartCoinBenefit = new BottomPartCoinBenefit(this.BOTTOM_PART_TYPE__ENLIST, playerMatType);
    this.bottomPartUpgradableCost__food = new BottomPartUpgradableCost__Food(playerMatType);
  }

  // types
  @Override
  public PlayerMatType getPlayerMatType() {
    return this.playerMatType;
  }

  @Override
  public BottomPartType getBottomPartType() {
    return this.BOTTOM_PART_TYPE__ENLIST;
  }

  // state changes
  @Override
  public BottomPartUpgradableCost getBottomPart_UpgradableCost() {
    return this.bottomPartUpgradableCost__food;
  }

  @Override
  public BottomPartCoinBenefit getBottomPartCoinBenefit() {
    return this.bottomPartCoinBenefit;
  }
}