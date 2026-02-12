package org.sa.b_storage.reward;

import org.sa.DTO.PlayerDTO;

public interface Reward {
  public abstract void applyToPlayer(PlayerDTO player);
}