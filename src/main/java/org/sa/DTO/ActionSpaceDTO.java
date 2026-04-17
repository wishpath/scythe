package org.sa.DTO;

import org.sa.enums.ActionBottom;
import org.sa.enums.ActionTop;
import org.sa.reward.cost_upgradable.UpgradableCost;
import org.sa.reward.reward_basic.RewardBasic_Coins;
import org.sa.reward.upgradable_state_change_top.UpgradableStateChange_Top;

//contains state, upgradable, through the game
public class ActionSpaceDTO {

  //TODO: each reward (pay or get) should have int amount (state) (upgradable) (initial) (max)
  public ActionTop actionTop;
  public UpgradableCost actionTopCost;
  public UpgradableStateChange_Top[] actionTop_Rewards_toChoose_upgradable;

  ActionBottom actionBottom;
  public UpgradableCost actionBottomUpgradableCost;
  public RewardBasic_Coins actionBottomCoinReward;

  public ActionSpaceDTO(
      ActionTop actionTop,
      UpgradableCost actionTopCost,
      UpgradableStateChange_Top[] actionTopRewards_toPickFrom,

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