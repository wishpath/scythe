package org.sa.player_mat.bottom_parts.bottom_part_coin_benefit;

import org.sa.DTO.PlayerDTO;
import org.sa.enums.ResourceType;
import org.sa.player_mat.PlayerMat__type_and_structure;
import org.sa.player_mat.bottom_parts.TYPE__BottomPart__BottomPartAction;

public class BottomPartCoinBenefit {
  private int deltaCoins;

  public BottomPartCoinBenefit(TYPE__BottomPart__BottomPartAction bottomPartType__upgrade, PlayerMat__type_and_structure playerMatType) {
    this.deltaCoins = BottomAction_CoinRewardMap.pickBottomActionCoinReward(bottomPartType__upgrade, playerMatType);
  }

  public void applyToPlayer(PlayerDTO player) {
    player.addResource(ResourceType.COINS, deltaCoins);
  }

  public int getCurrentChangeDelta() {
    return deltaCoins;
  }
}