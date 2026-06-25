package org.sa.state_change_bonus_reward_ability.reward_basic;

import org.sa.DTO.PlayerDTO;
import org.sa.enums.ResourceType;
import org.sa.state_change_bonus_reward_ability.StateChange;

public class ElistActionOneTimeReward_FromFactionMat_Coins implements StateChange {
  private int deltaCoins;

  public ElistActionOneTimeReward_FromFactionMat_Coins(int deltaCoins) {
    this.deltaCoins = deltaCoins;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.addResource(ResourceType.COINS, deltaCoins);
  }

  @Override
  public int getCurrentChangeDelta() {
    return deltaCoins;
  }
}
