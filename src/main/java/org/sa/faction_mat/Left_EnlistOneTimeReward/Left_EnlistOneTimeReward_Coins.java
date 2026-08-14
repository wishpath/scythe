package org.sa.faction_mat.Left_EnlistOneTimeReward;

import org.sa.PlayerDTO;
import org.sa.enums.OtherResourceType;

public class Left_EnlistOneTimeReward_Coins implements Left_EnlistOneTimeReward {
  private int deltaCoins;

  public Left_EnlistOneTimeReward_Coins(int deltaCoins) {
    this.deltaCoins = deltaCoins;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    player.addLocatableResource(OtherResourceType.COINS, deltaCoins);
  }
}
