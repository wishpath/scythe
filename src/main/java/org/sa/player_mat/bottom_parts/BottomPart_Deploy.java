package org.sa.player_mat.bottom_parts;

import org.sa.enums.ResourceType;
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

  // neighbor bonus
  public BottomPartType BOTTOM_PART_NEIGHBOR_TRIGGER__DEPLOY = BottomPartType.DEPLOY; // what neighbour bottom action triggers neighbor benefit
  public ResourceType BOTTOM_PART_NEIGHBOR_BENEFIT_TYPE__COINS = ResourceType.COINS;  //common for all player mat DEPLOY actions
  public int BOTTOM_PART_NEIGHBOR_BENEFIT_DELTA__ONE = 1; //absolutely common in all cases (all player mats, all actions)

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

  // neighbor bonus
  @Override
  public BottomPartType getType_NeighborTrigger() {
    return this.BOTTOM_PART_NEIGHBOR_TRIGGER__DEPLOY;
  }
  @Override
  public ResourceType getType_NeighborBenefit() {
    return this.BOTTOM_PART_NEIGHBOR_BENEFIT_TYPE__COINS;
  }
  @Override
  public int getDelta_NeighborBenefit_ONE() {
    return this.BOTTOM_PART_NEIGHBOR_BENEFIT_DELTA__ONE;
  }
}