package org.sa.state_change_bonus_reward_ability.reward_basic;

import org.sa.DTO.PlayerDTO;
import org.sa.state_change_bonus_reward_ability.StateChange;

public class ElistActionOneTimeReward_FromFactionMat_Attack implements StateChange {
  private int deltaAttack;

  public ElistActionOneTimeReward_FromFactionMat_Attack(int deltaAttack) {
    this.deltaAttack = deltaAttack;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.attack += deltaAttack;
  }

  @Override
  public int getCurrentChangeDelta() {
    return deltaAttack;
  }
}
