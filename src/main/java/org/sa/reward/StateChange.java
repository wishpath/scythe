package org.sa.reward;

import org.sa.DTO.PlayerDTO;

public interface StateChange {
  public abstract void applyToPlayer(PlayerDTO player);
}