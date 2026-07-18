package org.sa.player_mat.bottom_parts.bottom_part_coin_benefit;

import org.sa.PlayerDTO;
import org.sa.enums.ResourceType;
import org.sa.player_mat.PlayerMatType;
import org.sa.player_mat.bottom_parts.enums_and_interfaces.BottomPartType;

public class BottomPartCoinBenefit {
  private int deltaCoins;

  public BottomPartCoinBenefit(BottomPartType bottomPartType__upgrade, PlayerMatType playerMatType) {
    this.deltaCoins = BottomAction_CoinRewardMap.pickBottomActionCoinReward(bottomPartType__upgrade, playerMatType);
  }

  public void applyToPlayer(PlayerDTO player) {
    player.addResource(ResourceType.COINS, deltaCoins);
  }

  public int getCurrentChangeDelta() {
    return deltaCoins;
  }
}