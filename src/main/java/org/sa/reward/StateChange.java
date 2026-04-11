package org.sa.reward;

import org.sa.DTO.PlayerDTO;

public interface StateChange {
  public void applyToPlayer(PlayerDTO player);
  public int getCurrentChangeDelta();
}