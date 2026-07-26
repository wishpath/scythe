package org.sa.faction_mat.Left_EnlistOneTimeReward;

import org.sa.PlayerDTO;
import org.sa.enums.ResourceType;

public class Left_EnlistOneTimeReward_Coins implements Left_EnlistOneTimeReward {
  private int deltaCoins;

  public Left_EnlistOneTimeReward_Coins(int deltaCoins) {
    this.deltaCoins = deltaCoins;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.addResource(ResourceType.COINS, deltaCoins);
  }
}
