package org.sa.faction_mat.RightMid_FactionInitialBonus;

import org.sa.PlayerDTO;
import org.sa.enums.OtherResourceType;

public class RightMid_FactionInitialBonus_AttackCards implements RightMid_FactionInitialBonus {
  private int deltaAttackCardAmount;

  public RightMid_FactionInitialBonus_AttackCards(int deltaAttackCardAmount) {
    this.deltaAttackCardAmount = deltaAttackCardAmount;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.addLocatableResource(OtherResourceType.COMBAT_CARDS, deltaAttackCardAmount);
  }
}
