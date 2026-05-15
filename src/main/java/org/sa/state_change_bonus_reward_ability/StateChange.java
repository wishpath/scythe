package org.sa.state_change_bonus_reward_ability;

import org.sa.DTO.PlayerDTO;

public interface StateChange {
  public void applyToPlayer(PlayerDTO player);
  public int getCurrentChangeDelta();
}