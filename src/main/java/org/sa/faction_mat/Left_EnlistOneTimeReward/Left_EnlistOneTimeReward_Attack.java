package org.sa.faction_mat.Left_EnlistOneTimeReward;

import org.sa.PlayerDTO;
import org.sa.enums.ResourceType;

public class Left_EnlistOneTimeReward_Attack implements Left_EnlistOneTimeReward {
  private int deltaAttack;

  public Left_EnlistOneTimeReward_Attack(int deltaAttack) {
    this.deltaAttack = deltaAttack;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.addResource(ResourceType.ATTACK, deltaAttack);
  }
}
