package org.sa.player_mat.bottom_parts.bottom_part_coin_benefit;

import org.sa.DTO.PlayerDTO;
import org.sa.player_mat.PlayerMat__type_and_structure;
import org.sa.player_mat.bottom_parts.TYPE__BottomPart__BottomPartAction;

import java.util.Map;

import static org.sa.player_mat.PlayerMat__type_and_structure.*;

public class BottomPartCoinBenefit {
  public static final Map<BottomActionOnPlayerMat, Integer> BOTTOM_ACTION_COIN_REWARD = Map.ofEntries(

      // AGRICULTURAL
      Map.entry(new BottomActionOnPlayerMat(TYPE__BottomPart__BottomPartAction.UPGRADE, AGRICULTURAL), 1),
      Map.entry(new BottomActionOnPlayerMat(TYPE__BottomPart__BottomPartAction.DEPLOY,  AGRICULTURAL), 0),
      Map.entry(new BottomActionOnPlayerMat(TYPE__BottomPart__BottomPartAction.BUILD,   AGRICULTURAL), 2),
      Map.entry(new BottomActionOnPlayerMat(TYPE__BottomPart__BottomPartAction.ENLIST,  AGRICULTURAL), 3),

      // ENGINEERING
      Map.entry(new BottomActionOnPlayerMat(TYPE__BottomPart__BottomPartAction.UPGRADE, ENGINEERING), 2),
      Map.entry(new BottomActionOnPlayerMat(TYPE__BottomPart__BottomPartAction.DEPLOY,  ENGINEERING), 0),
      Map.entry(new BottomActionOnPlayerMat(TYPE__BottomPart__BottomPartAction.BUILD,   ENGINEERING), 3),
      Map.entry(new BottomActionOnPlayerMat(TYPE__BottomPart__BottomPartAction.ENLIST,  ENGINEERING), 1),

      // INDUSTRIAL
      Map.entry(new BottomActionOnPlayerMat(TYPE__BottomPart__BottomPartAction.UPGRADE, INDUSTRIAL), 3),
      Map.entry(new BottomActionOnPlayerMat(TYPE__BottomPart__BottomPartAction.DEPLOY,  INDUSTRIAL), 2),
      Map.entry(new BottomActionOnPlayerMat(TYPE__BottomPart__BottomPartAction.BUILD,   INDUSTRIAL), 1),
      Map.entry(new BottomActionOnPlayerMat(TYPE__BottomPart__BottomPartAction.ENLIST,  INDUSTRIAL), 0),

      // MECHANICAL
      Map.entry(new BottomActionOnPlayerMat(TYPE__BottomPart__BottomPartAction.UPGRADE, MECHANICAL), 0),
      Map.entry(new BottomActionOnPlayerMat(TYPE__BottomPart__BottomPartAction.DEPLOY,  MECHANICAL), 2),
      Map.entry(new BottomActionOnPlayerMat(TYPE__BottomPart__BottomPartAction.BUILD,   MECHANICAL), 2),
      Map.entry(new BottomActionOnPlayerMat(TYPE__BottomPart__BottomPartAction.ENLIST,  MECHANICAL), 2),

      // PATRIOTIC
      Map.entry(new BottomActionOnPlayerMat(TYPE__BottomPart__BottomPartAction.UPGRADE, PATRIOTIC), 1),
      Map.entry(new BottomActionOnPlayerMat(TYPE__BottomPart__BottomPartAction.DEPLOY,  PATRIOTIC), 3),
      Map.entry(new BottomActionOnPlayerMat(TYPE__BottomPart__BottomPartAction.BUILD,   PATRIOTIC), 0),
      Map.entry(new BottomActionOnPlayerMat(TYPE__BottomPart__BottomPartAction.ENLIST,  PATRIOTIC), 2),

      // INNOVATIVE
      Map.entry(new BottomActionOnPlayerMat(TYPE__BottomPart__BottomPartAction.UPGRADE, INNOVATIVE), 3),
      Map.entry(new BottomActionOnPlayerMat(TYPE__BottomPart__BottomPartAction.DEPLOY,  INNOVATIVE), 1),
      Map.entry(new BottomActionOnPlayerMat(TYPE__BottomPart__BottomPartAction.BUILD,   INNOVATIVE), 2),
      Map.entry(new BottomActionOnPlayerMat(TYPE__BottomPart__BottomPartAction.ENLIST,  INNOVATIVE), 0),

      // MILITANT
      Map.entry(new BottomActionOnPlayerMat(TYPE__BottomPart__BottomPartAction.UPGRADE, MILITANT), 0),
      Map.entry(new BottomActionOnPlayerMat(TYPE__BottomPart__BottomPartAction.DEPLOY,  MILITANT), 3),
      Map.entry(new BottomActionOnPlayerMat(TYPE__BottomPart__BottomPartAction.BUILD,   MILITANT), 1),
      Map.entry(new BottomActionOnPlayerMat(TYPE__BottomPart__BottomPartAction.ENLIST,  MILITANT), 2)
  );

  private int deltaCoins;

  public BottomPartCoinBenefit(TYPE__BottomPart__BottomPartAction bottomPartType__upgrade, PlayerMat__type_and_structure playerMatType) {
    this.deltaCoins = BOTTOM_ACTION_COIN_REWARD.get(new BottomActionOnPlayerMat(bottomPartType__upgrade, playerMatType));
  }

  public void applyToPlayer(PlayerDTO player) {
    player.coins += deltaCoins;
  }

  public int getCurrentChangeDelta() {
    return deltaCoins;
  }
}
record BottomActionOnPlayerMat(
    TYPE__BottomPart__BottomPartAction bottomAction,
    PlayerMat__type_and_structure playerMat
) {}