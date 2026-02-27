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
  public Reward topCostAndBenefit1;
  public Reward topCostAndBenefit2;
  public Reward topCostAndBenefit3;
  public Reward topCostAndBenefit4;

  ActionBottom actionBottom;
  public UpgradableCost upgradableCost;
  public Reward_Coins bottomActionCoinReward;
  public Reward bottomCostAndBenefit3;
  public Reward bottomCostAndBenefit4;

  public ActionSpaceDTO(ActionBottom actionBottom, UpgradableCost upgradableCost, int bottomActionCoinRewardDeltaCoins) {
    this.actionBottom = actionBottom;
    this.upgradableCost = upgradableCost;
    this.bottomActionCoinReward = new Reward_Coins(bottomActionCoinRewardDeltaCoins);
  }
}