package org.sa.DTO;

import org.sa.enums.ActionBottom;
import org.sa.enums.ActionTop;
import org.sa.reward.StateChange;
import org.sa.reward.reward_basic.RewardBasic_Coins;
import org.sa.reward.cost_upgradable.UpgradableCost;

//contains state, upgradable, through the game
public class ActionSpaceDTO {

  //TODO: each reward (pay or get) should have int amount (state) (upgradable) (initial) (max)
  public ActionTop actionTop;
  public UpgradableCost actionTopCost;
  public StateChange[] actionTop_Rewards_toChoose_upgradable;

  ActionBottom actionBottom;
  public UpgradableCost actionBottomUpgradableCost;
  public RewardBasic_Coins actionBottomCoinReward;

  public ActionSpaceDTO(
      ActionTop actionTop,
      UpgradableCost actionTopCost,
      StateChange[] actionTopRewards_toPickFrom,

      ActionBottom actionBottom,
      UpgradableCost actionBottomUpgradableCost,
      int actionBottomCoinRewardDeltaCoins) {

    this.actionTop = actionTop;
    this.actionTopCost = actionTopCost;
    this.actionTop_Rewards_toChoose_upgradable = actionTopRewards_toPickFrom;

    this.actionBottom = actionBottom;
    this.actionBottomUpgradableCost = actionBottomUpgradableCost;
    this.actionBottomCoinReward = new RewardBasic_Coins(actionBottomCoinRewardDeltaCoins);
  }
}