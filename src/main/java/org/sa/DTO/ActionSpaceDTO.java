package org.sa.DTO;

import org.sa.enums.ActionBottom;
import org.sa.enums.ActionTop;
import org.sa.reward.Reward;
import org.sa.reward.UpgradableReward;

public class ActionSpaceDTO {
  //TODO: each reward (pay or get) should have int amount (state) (upgradable) (initial) (max)
  public ActionTop actionTop;
  public Reward topCostAndBenefit1;
  public Reward topCostAndBenefit2;
  public Reward topCostAndBenefit3;
  public Reward topCostAndBenefit4;

  ActionBottom actionBottom;
  public Reward upgradableCost;
  public Reward bottomCostAndBenefit2;
  public Reward bottomCostAndBenefit3;
  public Reward bottomCostAndBenefit4;

  public ActionSpaceDTO(ActionBottom actionBottom, UpgradableReward upgradableCost) {
    this.actionBottom = actionBottom;
    this.upgradableCost = upgradableCost;
  }
}