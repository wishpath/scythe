package org.sa.player_mat.bottom_parts;

import org.sa.enums.ResourceType;
import org.sa.player_mat.PlayerMat__type_and_structure;
import org.sa.player_mat.bottom_parts.bottom_part_coin_benefit.BottomPartCoinBenefit;
import org.sa.player_mat.bottom_parts.bottom_part_cost.BottomPartUpgradableCost__Oil;

public class BottomPart_actionOfUpgrade {

  //types
  public PlayerMat__type_and_structure playerMatType; //example AGRICULTURAL
  public TYPE__BottomPart__BottomPartAction BOTTOM_PART_TYPE__UPGRADE = TYPE__BottomPart__BottomPartAction.UPGRADE;

  // state changes
  public BottomPartUpgradableCost__Oil bottomPartUpgradableCost__oil;
  public BottomPartCoinBenefit bottomPartCoinBenefit;

  // neighbor bonus
  public TYPE__BottomPart__BottomPartAction BOTTOM_PART_NEIGHBOR_TRIGGER__UPGRADE = TYPE__BottomPart__BottomPartAction.UPGRADE; // what neighbour bottom action triggers neighbor benefit
  public ResourceType BOTTOM_PART_NEIGHBOR_BENEFIT_TYPE__POWER = ResourceType.ATTACK;
  public int BOTTOM_PART_NEIGHBOR_BENEFIT_DELTA__ONE = 1; //absolutely common in all cases


  /** constructor */
  public BottomPart_actionOfUpgrade(PlayerMat__type_and_structure playerMatType) {
    this.playerMatType = playerMatType;
    this.bottomPartCoinBenefit = new BottomPartCoinBenefit(this.BOTTOM_PART_TYPE__UPGRADE, playerMatType);
    this.bottomPartUpgradableCost__oil = new BottomPartUpgradableCost__Oil(playerMatType); //TODO create constructor
  }
}
