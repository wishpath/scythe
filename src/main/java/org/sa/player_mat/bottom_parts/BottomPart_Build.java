package org.sa.player_mat.bottom_parts;

import org.sa.player_mat.PlayerMatType;
import org.sa.player_mat.bottom_parts.bottom_part_coin_benefit.BottomPartCoinBenefit;
import org.sa.player_mat.bottom_parts.bottom_part_cost.BottomPartUpgradableCost;
import org.sa.player_mat.bottom_parts.bottom_part_cost.BottomPartUpgradableCost__Wood;
import org.sa.player_mat.bottom_parts.enums_and_interfaces.BottomPart;
import org.sa.player_mat.bottom_parts.enums_and_interfaces.BottomPartType;

public class BottomPart_Build implements BottomPart {

  //types
  public PlayerMatType playerMatType; //example AGRICULTURAL
  public BottomPartType BOTTOM_PART_TYPE__BUILD = BottomPartType.BUILD;

  // state changes
  public BottomPartUpgradableCost__Wood bottomPartUpgradableCost__wood;
  public BottomPartCoinBenefit bottomPartCoinBenefit;

  /** constructor */
  public BottomPart_Build(PlayerMatType playerMatType) {
    this.playerMatType = playerMatType;
    this.bottomPartCoinBenefit = new BottomPartCoinBenefit(this.BOTTOM_PART_TYPE__BUILD, playerMatType);
    this.bottomPartUpgradableCost__wood = new BottomPartUpgradableCost__Wood(playerMatType);
  }

  //types
  @Override
  public PlayerMatType getPlayerMatType() {
    return this.playerMatType;
  }

  @Override
  public BottomPartType getBottomPartType() {
    return this.BOTTOM_PART_TYPE__BUILD;
  }

  //state changes
  @Override
  public BottomPartUpgradableCost getBottomPart_UpgradableCost() {
    return this.bottomPartUpgradableCost__wood;
  }

  @Override
  public BottomPartCoinBenefit getBottomPartCoinBenefit() {
    return this.bottomPartCoinBenefit;
  }
}
