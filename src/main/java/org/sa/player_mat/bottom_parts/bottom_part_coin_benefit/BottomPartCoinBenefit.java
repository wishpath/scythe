package org.sa.player_mat.bottom_parts.bottom_part_coin_benefit;

import org.sa.DTO.PlayerDTO;
import org.sa.player_mat.PlayerMat__type_and_structure;
import org.sa.player_mat.bottom_parts.TYPE__BottomPart__BottomPartAction;

import static org.sa.player_mat.bottom_parts.bottom_part_coin_benefit.BottomAction_CoinRewardMap.BOTTOM_ACTION_COIN_REWARD;

public class BottomPartCoinBenefit {
  private int deltaCoins;

  public BottomPartCoinBenefit(TYPE__BottomPart__BottomPartAction bottomPartType__upgrade, PlayerMat__type_and_structure playerMatType) {
    this.deltaCoins = BOTTOM_ACTION_COIN_REWARD.get(new Pair__BottomAction__PlayerMat(bottomPartType__upgrade, playerMatType));
  }

  public void applyToPlayer(PlayerDTO player) {
    player.coins += deltaCoins;
  }

  public int getCurrentChangeDelta() {
    return deltaCoins;
  }
}