package org.sa.player_mat.a_top_parts.top_part_cost;

import org.sa.DTO.PlayerDTO;
import org.sa.enums.ResourceType;

public class TopPartCost_Minus1Coin implements TopPartCost {

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.addResource(ResourceType.COINS, -1);
  }
}