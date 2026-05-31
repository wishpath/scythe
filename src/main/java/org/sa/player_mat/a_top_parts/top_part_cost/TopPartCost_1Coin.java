package org.sa.player_mat.a_top_parts.top_part_cost;

import org.sa.DTO.PlayerDTO;

public class TopPartCost_1Coin implements TopPartCost {
  private final int MINUS_ONE_COIN = -1;

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.coins += MINUS_ONE_COIN;
  }
}