package org.sa.player_mat.bottom_parts.bottom_part_cost;

import org.sa.PlayerDTO;

public interface BottomPartUpgradableCost {
  void applyToPlayer(PlayerDTO player);

  int getCurrentChangeDelta();

  boolean canUpgrade();

  void upgrade_lowerTheCost();
}
