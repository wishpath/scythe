package org.sa.state_change_bonus_reward_ability.reward_basic;

import org.sa.DTO.PlayerDTO;
import org.sa.enums.ResourceType;
import org.sa.state_change_bonus_reward_ability.StateChange;

public class ElistActionOneTimeReward_FromFactionMat_Hearts implements StateChange {
  private int deltaHearts;

  public ElistActionOneTimeReward_FromFactionMat_Hearts(int deltaHearts) {
    this.deltaHearts = deltaHearts;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.addResource(ResourceType.HEARTS, deltaHearts);
  }

  @Override
  public int getCurrentChangeDelta() {
    return deltaHearts;
  }
}
