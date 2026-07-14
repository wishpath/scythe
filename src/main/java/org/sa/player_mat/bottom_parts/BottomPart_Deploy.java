package org.sa.player_mat.bottom_parts;

import org.sa.player_mat.PlayerMatType;
import org.sa.player_mat.bottom_parts.bottom_part_coin_benefit.BottomPartCoinBenefit;
import org.sa.player_mat.bottom_parts.bottom_part_cost.BottomPartUpgradableCost;
import org.sa.player_mat.bottom_parts.bottom_part_cost.BottomPartUpgradableCost__Metal;
import org.sa.player_mat.bottom_parts.enums_and_interfaces.BottomPart;
import org.sa.player_mat.bottom_parts.enums_and_interfaces.BottomPartType;

public class BottomPart_Deploy implements BottomPart {

  // types
  public PlayerMatType playerMatType;  //example AGRICULTURAL
  public BottomPartType BOTTOM_PART_TYPE__DEPLOY = BottomPartType.DEPLOY;

  // state changes
  public BottomPartUpgradableCost__Metal bottomPartUpgradableCost__metal;
  public BottomPartCoinBenefit bottomPartCoinBenefit;

  /** constructor */
  public BottomPart_Deploy(PlayerMatType playerMatType) {
    this.playerMatType = playerMatType;
    this.bottomPartCoinBenefit = new BottomPartCoinBenefit(this.BOTTOM_PART_TYPE__DEPLOY, playerMatType);
    this.bottomPartUpgradableCost__metal = new BottomPartUpgradableCost__Metal(playerMatType);
  }

  // types
  @Override
  public PlayerMatType getPlayerMatType() {
    return this.playerMatType;
  }
  @Override
  public BottomPartType getBottomPartType() {
    return this.BOTTOM_PART_TYPE__DEPLOY;
  }

  // state changes
  @Override
  public BottomPartUpgradableCost getBottomPart_UpgradableCost() {
    return this.bottomPartUpgradableCost__metal;
  }
  @Override
  public BottomPartCoinBenefit getBottomPartCoinBenefit() {
    return this.bottomPartCoinBenefit;
  }
}