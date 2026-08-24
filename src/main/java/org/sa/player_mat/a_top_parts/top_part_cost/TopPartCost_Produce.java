package org.sa.player_mat.a_top_parts.top_part_cost;

import org.sa.PlayerDTO;
import org.sa.enums.IntResourceType;

public class TopPartCost_Produce implements TopPartCost {
  private final int COMMON_DELTA_AMOUNT = -1;

  @Override
  public void applyToPlayer(PlayerDTO player) {
    int workerCount = player.getPlacedWorkers().size();
    if (workerCount >= 4) player.deltaIntResource(IntResourceType.ATTACK, COMMON_DELTA_AMOUNT);
    if (workerCount >= 5) player.deltaIntResource(IntResourceType.HEARTS, COMMON_DELTA_AMOUNT);
    if (workerCount >= 6) player.deltaIntResource(IntResourceType.COINS, COMMON_DELTA_AMOUNT);
  }

  @Override
  public boolean hasPlayerResourcesToPayForThisTopPart(PlayerDTO player) {
    int workerCount = player.getPlacedWorkers().size();
    if (workerCount >= 4) {
      int amountPlayerHas = player.intResourceMap.get(IntResourceType.ATTACK);
      if (amountPlayerHas + COMMON_DELTA_AMOUNT < 0) return false;
    }
    if (workerCount >= 5) {
      int amountPlayerHas = player.intResourceMap.get(IntResourceType.HEARTS);
      if (amountPlayerHas + COMMON_DELTA_AMOUNT < 0) return false;
    }
    if (workerCount >= 6) {
      int amountPlayerHas = player.intResourceMap.get(IntResourceType.COINS);
      if (amountPlayerHas + COMMON_DELTA_AMOUNT < 0) return false;
    }
    return true;
  }
}