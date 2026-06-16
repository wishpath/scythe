package org.sa.player_mat.a_top_parts.top_part_cost;

import org.sa.DTO.PlayerDTO;
import org.sa.enums.ResourceType;

public class TopPartCost_Produce implements TopPartCost {

  @Override
  public void applyToPlayer(PlayerDTO player) {
    int workerCount = player.placed_workers.size();
    if (workerCount >= 4) player.addResource(ResourceType.ATTACK, -1);
    if (workerCount >= 5) player.addResource(ResourceType.HEARTS, -1);
    if (workerCount >= 6) player.addResource(ResourceType.COINS, -1);;
  }
}