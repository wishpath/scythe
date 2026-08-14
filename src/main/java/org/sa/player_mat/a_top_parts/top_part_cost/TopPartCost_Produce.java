package org.sa.player_mat.a_top_parts.top_part_cost;

import org.sa.PlayerDTO;
import org.sa.enums.OtherResourceType;

public class TopPartCost_Produce implements TopPartCost {

  @Override
  public void applyToPlayer(PlayerDTO player) {
    int workerCount = player.getPlacedWorkers().size();
    if (workerCount >= 4) player.addLocatableResource(OtherResourceType.ATTACK, -1);
    if (workerCount >= 5) player.addLocatableResource(OtherResourceType.HEARTS, -1);
    if (workerCount >= 6) player.addLocatableResource(OtherResourceType.COINS, -1);;
  }
}