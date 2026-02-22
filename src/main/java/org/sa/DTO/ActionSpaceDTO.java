package org.sa.DTO;

import org.sa.enums.ActionBottom;
import org.sa.enums.ActionTop;
import org.sa.reward.Reward;

public class ActionSpaceDTO {
  //TODO: each reward (pay or get) should have int amount (state) (upgradable) (initial) (max)
  ActionTop actionTop;
  Reward topCostAndBenefit1;
  Reward topCostAndBenefit2;
  Reward topCostAndBenefit3;
  Reward topCostAndBenefit4;

  ActionBottom actionBottom;
  Reward bottomCostAndBenefit1;
  Reward bottomCostAndBenefit2;
  Reward bottomCostAndBenefit3;
  Reward bottomCostAndBenefit4;
}