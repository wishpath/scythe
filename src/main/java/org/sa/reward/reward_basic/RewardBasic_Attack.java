package org.sa.reward.reward_basic;

import org.sa.DTO.PlayerDTO;
import org.sa.reward.StateChange;

public class RewardBasic_Attack implements StateChange {
  private int deltaAttack;

  public RewardBasic_Attack(int deltaAttack) {
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
