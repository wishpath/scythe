package org.sa.player_mat.bottom_parts;

import org.sa.enums.ResourceType;
import org.sa.player_mat.PlayerMatType;
import org.sa.player_mat.bottom_parts.bottom_part_coin_benefit.BottomPartCoinBenefit;
import org.sa.player_mat.bottom_parts.bottom_part_cost.BottomPartUpgradableCost;
import org.sa.player_mat.bottom_parts.bottom_part_cost.BottomPartUpgradableCost__Oil;
import org.sa.player_mat.bottom_parts.enums_and_interfaces.BottomPart;
import org.sa.player_mat.bottom_parts.enums_and_interfaces.BottomPartType;

public class BottomPart_actionOfUpgrade implements BottomPart {

  //types
  public PlayerMatType playerMatType; //example AGRICULTURAL
  public BottomPartType BOTTOM_PART_TYPE__UPGRADE = BottomPartType.UPGRADE;

  // state changes
  public BottomPartUpgradableCost__Oil bottomPartUpgradableCost__oil;
  public BottomPartCoinBenefit bottomPartCoinBenefit;

  // neighbor bonus
  public BottomPartType BOTTOM_PART_NEIGHBOR_TRIGGER__UPGRADE = BottomPartType.UPGRADE; // what neighbour bottom action triggers neighbor benefit
  public ResourceType BOTTOM_PART_NEIGHBOR_BENEFIT_TYPE__ATTACK = ResourceType.ATTACK; //common for all player mat UPGRADE actions
  public int BOTTOM_PART_NEIGHBOR_BENEFIT_DELTA__ONE = 1; //absolutely common in all cases (all player mats, all actions)


  /** constructor */
  public BottomPart_actionOfUpgrade(PlayerMatType playerMatType) {
    this.playerMatType = playerMatType;
    this.bottomPartCoinBenefit = new BottomPartCoinBenefit(this.BOTTOM_PART_TYPE__UPGRADE, playerMatType);
    this.bottomPartUpgradableCost__oil = new BottomPartUpgradableCost__Oil(playerMatType);
  }

  //types
  @Override
  public PlayerMatType getPlayerMatType() {
    return this.playerMatType;
  }
  @Override
  public BottomPartType getBottomPartType() {
    return this.BOTTOM_PART_TYPE__UPGRADE;
  }

  //state changes
  @Override
  public BottomPartUpgradableCost getBottomPart_UpgradableCost() {
    return this.bottomPartUpgradableCost__oil;
  }
  @Override
  public BottomPartCoinBenefit getBottomPartCoinBenefit() {
    return this.bottomPartCoinBenefit;
  }

  // neighbor bonus
  @Override
  public BottomPartType getType_NeighborTrigger() {
    return this.BOTTOM_PART_NEIGHBOR_TRIGGER__UPGRADE;
  }
  @Override
  public ResourceType getType_NeighborBenefit() {
    return this.BOTTOM_PART_NEIGHBOR_BENEFIT_TYPE__ATTACK;
  }
  @Override
  public int getDelta_NeighborBenefit_ONE() {
    return this.BOTTOM_PART_NEIGHBOR_BENEFIT_DELTA__ONE;
  }
}
