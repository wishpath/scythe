package org.sa.b_storage.reward;

import org.sa.DTO.PlayerDTO;

public class Reward_RiverCrossingToOrFromTunnel_Burrow implements Reward {

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.canCrossRiverToOrFromTunnel = true;
  }
}

