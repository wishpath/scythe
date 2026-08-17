package org.sa.faction_mat.Left_EnlistOneTimeReward;

import org.sa.PlayerDTO;
import org.sa.enums.IntResourceType;

public class Left_EnlistOneTimeReward_Hearts implements Left_EnlistOneTimeReward {
  private int deltaHearts;

  public Left_EnlistOneTimeReward_Hearts(int deltaHearts) {
    this.deltaHearts = deltaHearts;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.addLocatableResource(IntResourceType.HEARTS, deltaHearts);
  }
}
