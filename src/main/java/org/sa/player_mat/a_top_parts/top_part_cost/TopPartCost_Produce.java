package org.sa.player_mat.a_top_parts.top_part_cost;

import org.sa.DTO.PlayerDTO;

public class TopPartCost_Produce implements TopPartCost {

  @Override
  public void applyToPlayer(PlayerDTO player) {
    int workerCount = player.placed_workers.size();
    if (workerCount >= 4) player.attack--;
    if (workerCount >= 5) player.hearts--;
    if (workerCount >= 6) player.coins--;
  }
}