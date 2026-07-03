package org.sa.player_mat.bottom_parts.bottom_part_coin_benefit;

import org.sa.player_mat.PlayerMatType;
import org.sa.player_mat.bottom_parts.enums_and_interfaces.BottomPartType;

import java.util.Map;

import static org.sa.player_mat.PlayerMatType.*;

public class BottomAction_CoinRewardMap {
  private static final Map<Pair__BottomAction__PlayerMat, Integer> BOTTOM_ACTION_COIN_REWARD = Map.ofEntries(

      // AGRICULTURAL
      Map.entry(new Pair__BottomAction__PlayerMat(BottomPartType.UPGRADE, AGRICULTURAL), 1),
      Map.entry(new Pair__BottomAction__PlayerMat(BottomPartType.DEPLOY,  AGRICULTURAL), 0),
      Map.entry(new Pair__BottomAction__PlayerMat(BottomPartType.BUILD,   AGRICULTURAL), 2),
      Map.entry(new Pair__BottomAction__PlayerMat(BottomPartType.ENLIST,  AGRICULTURAL), 3),

      // ENGINEERING
      Map.entry(new Pair__BottomAction__PlayerMat(BottomPartType.UPGRADE, ENGINEERING), 2),
      Map.entry(new Pair__BottomAction__PlayerMat(BottomPartType.DEPLOY,  ENGINEERING), 0),
      Map.entry(new Pair__BottomAction__PlayerMat(BottomPartType.BUILD,   ENGINEERING), 3),
      Map.entry(new Pair__BottomAction__PlayerMat(BottomPartType.ENLIST,  ENGINEERING), 1),

      // INDUSTRIAL
      Map.entry(new Pair__BottomAction__PlayerMat(BottomPartType.UPGRADE, INDUSTRIAL), 3),
      Map.entry(new Pair__BottomAction__PlayerMat(BottomPartType.DEPLOY,  INDUSTRIAL), 2),
      Map.entry(new Pair__BottomAction__PlayerMat(BottomPartType.BUILD,   INDUSTRIAL), 1),
      Map.entry(new Pair__BottomAction__PlayerMat(BottomPartType.ENLIST,  INDUSTRIAL), 0),

      // MECHANICAL
      Map.entry(new Pair__BottomAction__PlayerMat(BottomPartType.UPGRADE, MECHANICAL), 0),
      Map.entry(new Pair__BottomAction__PlayerMat(BottomPartType.DEPLOY,  MECHANICAL), 2),
      Map.entry(new Pair__BottomAction__PlayerMat(BottomPartType.BUILD,   MECHANICAL), 2),
      Map.entry(new Pair__BottomAction__PlayerMat(BottomPartType.ENLIST,  MECHANICAL), 2),

      // PATRIOTIC
      Map.entry(new Pair__BottomAction__PlayerMat(BottomPartType.UPGRADE, PATRIOTIC), 1),
      Map.entry(new Pair__BottomAction__PlayerMat(BottomPartType.DEPLOY,  PATRIOTIC), 3),
      Map.entry(new Pair__BottomAction__PlayerMat(BottomPartType.BUILD,   PATRIOTIC), 0),
      Map.entry(new Pair__BottomAction__PlayerMat(BottomPartType.ENLIST,  PATRIOTIC), 2),

      // INNOVATIVE
      Map.entry(new Pair__BottomAction__PlayerMat(BottomPartType.UPGRADE, INNOVATIVE), 3),
      Map.entry(new Pair__BottomAction__PlayerMat(BottomPartType.DEPLOY,  INNOVATIVE), 1),
      Map.entry(new Pair__BottomAction__PlayerMat(BottomPartType.BUILD,   INNOVATIVE), 2),
      Map.entry(new Pair__BottomAction__PlayerMat(BottomPartType.ENLIST,  INNOVATIVE), 0),

      // MILITANT
      Map.entry(new Pair__BottomAction__PlayerMat(BottomPartType.UPGRADE, MILITANT), 0),
      Map.entry(new Pair__BottomAction__PlayerMat(BottomPartType.DEPLOY,  MILITANT), 3),
      Map.entry(new Pair__BottomAction__PlayerMat(BottomPartType.BUILD,   MILITANT), 1),
      Map.entry(new Pair__BottomAction__PlayerMat(BottomPartType.ENLIST,  MILITANT), 2)
  );

  public static int pickBottomActionCoinReward(BottomPartType bottomPartType__upgrade, PlayerMatType playerMatType) {
    Pair__BottomAction__PlayerMat pickByThisPair = new Pair__BottomAction__PlayerMat(bottomPartType__upgrade, playerMatType);
    return BOTTOM_ACTION_COIN_REWARD.get(pickByThisPair);
  }

  private record Pair__BottomAction__PlayerMat(
      BottomPartType bottomAction,
      PlayerMatType playerMat
  ) {}
}
