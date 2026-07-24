package org.sa.faction_mat.right_side;

import org.sa.PlayerDTO;
import org.sa.enums.ResourceType;

public class RightMid_FactionInitialBonus_AttackCards implements RightMid_FactionInitialBonus {
  private int deltaAttackCardAmount;

  public RightMid_FactionInitialBonus_AttackCards(int deltaAttackCardAmount) {
    this.deltaAttackCardAmount = deltaAttackCardAmount;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.addResource(ResourceType.COMBAT_CARDS, deltaAttackCardAmount);
  }
}
