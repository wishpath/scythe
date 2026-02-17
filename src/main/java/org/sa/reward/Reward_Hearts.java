package org.sa.reward;

import org.sa.DTO.PlayerDTO;

public class Reward_Hearts implements Reward {
  private int deltaHearts;

  public Reward_Hearts(int deltaHearts) {
    this.deltaHearts = deltaHearts;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.hearts += deltaHearts;
  }
}
