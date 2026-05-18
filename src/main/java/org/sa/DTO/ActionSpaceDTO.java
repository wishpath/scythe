package org.sa.DTO;

import org.sa.enums.player_mat_enum.ActionBottom;
import org.sa.enums.player_mat_enum.ActionTop;
import org.sa.state_change_bonus_reward_ability.cost_upgradable.UpgradableCost;
import org.sa.state_change_bonus_reward_ability.reward_basic.ElistActionOneTimeReward_FromFactionMat_Coins;
import org.sa.state_change_bonus_reward_ability.upgradable_state_change_top.UpgradableStateChange_Top;

//contains state, upgradable, through the game
public class ActionSpaceDTO {

  //TODO: each reward (pay or get) should have int amount (state) (upgradable) (initial) (max)
  public ActionTop actionTop;
  public UpgradableCost actionTopCost;
  public UpgradableStateChange_Top[] actionTop_Rewards_toChoose_upgradable;

  ActionBottom actionBottom;
  public UpgradableCost actionBottomUpgradableCost;
  public ElistActionOneTimeReward_FromFactionMat_Coins actionBottomCoinReward;

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
    this.actionBottomCoinReward = new ElistActionOneTimeReward_FromFactionMat_Coins(actionBottomCoinRewardDeltaCoins);
  }
}