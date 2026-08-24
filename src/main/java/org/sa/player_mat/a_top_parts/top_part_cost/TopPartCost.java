package org.sa.player_mat.a_top_parts.top_part_cost;

import org.sa.PlayerDTO;
import org.sa.PlayerStateChange;

public interface TopPartCost extends PlayerStateChange {
  boolean hasPlayerResourcesToPayForThisTopPart(PlayerDTO player);
}
