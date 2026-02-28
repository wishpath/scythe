package org.sa.reward.enlistable_reward;

import org.sa.DTO.PlayerDTO;
import org.sa.enums.ActionBottom;

public class EnlistableReward_CoinPlusOne implements EnlistableReward {

  private final PlayerDTO player;
  private final ActionBottom triggeringAction = ActionBottom.DEPLOY;
  private boolean enlisted;

  public EnlistableReward_CoinPlusOne(PlayerDTO player) {
    this.player = player;
  }

  @Override
  public void enlist_turnOn() {
    enlisted = true;
  }

  @Override
  public boolean isEnlisted_isTurnedOn() {
    return enlisted;
  }

  @Override
  public boolean isTriggeredByNeighborAction(ActionBottom action) {
    return enlisted && action == triggeringAction;
  }

  public void apply() {
    if (!enlisted) throw new IllegalStateException(
        "Should only apply when enlisted and after trigger check."
    );
    player.coins++;
  }
}