package org.sa.player_mat.neighbor_bonus;

import org.sa.PlayerDTO;

public interface NeighborBonus {  public
  void applyToPlayer(PlayerDTO player);
  int getCurrentChangeDelta();
  void enlist_turnOn();
  boolean isEnlisted_isTurnedOn();
}
