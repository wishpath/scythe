package org.sa.state_change_bonus_reward_ability.reward_basic;

import org.sa.PlayerDTO;
import org.sa.enums.ResourceType;
import org.sa.state_change_bonus_reward_ability.StateChange;

public class ElistActionOneTimeReward_FromFactionMat_Attack implements StateChange {
  private int deltaAttack;

  public ElistActionOneTimeReward_FromFactionMat_Attack(int deltaAttack) {
    this.deltaAttack = deltaAttack;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.addResource(ResourceType.ATTACK, deltaAttack);
  }

  @Override
  public int getCurrentChangeDelta() {
    return deltaAttack;
  }
}
