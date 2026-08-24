package org.sa.player_mat.a_top_parts.top_part_cost;

import org.sa.PlayerDTO;
import org.sa.enums.IntResourceType;

public class TopPartCost_Minus1Coin implements TopPartCost {
  private final int AMOUNT_DELTA_MINUS_ONE = -1;

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.deltaIntResource(IntResourceType.COINS, AMOUNT_DELTA_MINUS_ONE);
  }

  @Override
  public boolean hasPlayerResourcesToPayForThisTopPart(PlayerDTO player) {
    int amountPlayerHas = player.intResourceMap.get(IntResourceType.COINS);
    return amountPlayerHas + AMOUNT_DELTA_MINUS_ONE >= 0;
  }
}