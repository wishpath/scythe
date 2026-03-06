package org.sa.DTO;

import org.sa.enums.ActionBottom;
import org.sa.enums.ActionTop;
import org.sa.reward.Reward;
import org.sa.reward.Reward_Coins;
import org.sa.reward.cost_upgradable.UpgradableCost;

//contains state, upgradable, through the game
public class ActionSpaceDTO {
  //TODO: each reward (pay or get) should have int amount (state) (upgradable) (initial) (max)
  public ActionTop actionTop;
  public Reward[] topRewards;

  ActionBottom actionBottom;
  public UpgradableCost upgradableCost;
  public Reward_Coins bottomActionCoinReward;

  public ActionSpaceDTO(ActionTop actionTop, Reward[] topRewards, ActionBottom actionBottom, UpgradableCost upgradableCost, int bottomActionCoinRewardDeltaCoins) {
    this.actionTop = actionTop;
    this.topRewards = topRewards;
    this.actionBottom = actionBottom;
    this.upgradableCost = upgradableCost;
    this.bottomActionCoinReward = new Reward_Coins(bottomActionCoinRewardDeltaCoins);
  }
}