package org.sa.faction_mat.Left_EnlistOneTimeReward;

import org.sa.PlayerDTO;
import org.sa.enums.ResourceType;

public class Left_EnlistOneTimeReward_AttackCards implements Left_EnlistOneTimeReward {
  private int deltaAttackCardAmount;

  public Left_EnlistOneTimeReward_AttackCards(int deltaAttackCardAmount) {
    this.deltaAttackCardAmount = deltaAttackCardAmount;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.addResource(ResourceType.COMBAT_CARDS, deltaAttackCardAmount);
  }
}
