package org.sa.faction_mat.Left_EnlistOneTimeReward;

import org.sa.PlayerDTO;
import org.sa.enums.OtherResourceType;

public class Left_EnlistOneTimeReward_AttackCards implements Left_EnlistOneTimeReward {
  private int deltaAttackCardAmount;

  public Left_EnlistOneTimeReward_AttackCards(int deltaAttackCardAmount) {
    this.deltaAttackCardAmount = deltaAttackCardAmount;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.addLocatableResource(OtherResourceType.COMBAT_CARDS, deltaAttackCardAmount);
  }
}
