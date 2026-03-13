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
  public UpgradableCost actionTopCost;
  public Reward[] actionTop_Rewards_toChoose_upgradable;

  ActionBottom actionBottom;
  public UpgradableCost actionBottomUpgradableCost;
  public Reward_Coins actionBottomCoinReward;

  public ActionSpaceDTO(
      ActionTop actionTop,
      UpgradableCost actionTopCost,
      Reward[] actionTopRewards,

      ActionBottom actionBottom,
      UpgradableCost actionBottomUpgradableCost,
      int actionBottomCoinRewardDeltaCoins) {

    this.actionTop = actionTop;
    this.actionTopCost = actionTopCost;
    this.actionTop_Rewards_toChoose_upgradable = actionTopRewards;

    this.actionBottom = actionBottom;
    this.actionBottomUpgradableCost = actionBottomUpgradableCost;
    this.actionBottomCoinReward = new Reward_Coins(actionBottomCoinRewardDeltaCoins);
  }
}