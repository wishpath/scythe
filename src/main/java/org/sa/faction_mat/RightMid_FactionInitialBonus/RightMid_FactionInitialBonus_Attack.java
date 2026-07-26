package org.sa.faction_mat.RightMid_FactionInitialBonus;

import org.sa.PlayerDTO;
import org.sa.enums.ResourceType;

public class RightMid_FactionInitialBonus_Attack implements RightMid_FactionInitialBonus {
  private int deltaAttack;

  public RightMid_FactionInitialBonus_Attack(int deltaAttack) {
    this.deltaAttack = deltaAttack;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.addResource(ResourceType.ATTACK, deltaAttack);
  }
}
