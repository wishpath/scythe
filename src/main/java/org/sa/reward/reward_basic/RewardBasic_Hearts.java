package org.sa.reward.reward_basic;

import org.sa.DTO.PlayerDTO;
import org.sa.reward.StateChange;

public class RewardBasic_Hearts implements StateChange {
  private int deltaHearts;

  public RewardBasic_Hearts(int deltaHearts) {
    this.deltaHearts = deltaHearts;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.hearts += deltaHearts;
  }
}
