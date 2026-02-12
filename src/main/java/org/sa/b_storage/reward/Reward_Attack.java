package org.sa.b_storage.reward;

import org.sa.DTO.PlayerDTO;

public class Reward_Attack implements Reward {
  private int deltaAttack;

  public Reward_Attack(int deltaAttack) {
    this.deltaAttack = deltaAttack;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.attack += deltaAttack;
  }
}
