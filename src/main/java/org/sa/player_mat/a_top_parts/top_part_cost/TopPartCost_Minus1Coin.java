package org.sa.player_mat.a_top_parts.top_part_cost;

import org.sa.PlayerDTO;
import org.sa.enums.OtherResourceType;

public class TopPartCost_Minus1Coin implements TopPartCost {

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.addLocatableResource(OtherResourceType.COINS, -1);
  }
}