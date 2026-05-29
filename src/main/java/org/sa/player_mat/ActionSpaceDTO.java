package org.sa.player_mat;

import org.sa.player_mat.a_TOPS.enums_and_interfaces.TYPE_TopPart_TopActionChooseArray_ActionSpace;
import org.sa.player_mat.a_TOPS.upgradable_state_change_top.interfaces.UpgradableStateChange_Top;
import org.sa.player_mat.b_BOTTOM.ActionBottom;
import org.sa.state_change_bonus_reward_ability.cost_upgradable.UpgradableCost;
import org.sa.state_change_bonus_reward_ability.reward_basic.ElistActionOneTimeReward_FromFactionMat_Coins;

//contains state, upgradable, through the game
public class ActionSpaceDTO {

  //TODO: each reward (pay or get) should have int amount (state) (upgradable) (initial) (max)
  public TYPE_TopPart_TopActionChooseArray_ActionSpace actionTop;
  public UpgradableCost actionTopCost;
  public UpgradableStateChange_Top[] actionTop_Rewards_toChoose_upgradable;

  ActionBottom actionBottom;
  public UpgradableCost actionBottomUpgradableCost;
  public ElistActionOneTimeReward_FromFactionMat_Coins actionBottomCoinReward;

  public ActionSpaceDTO(
      TYPE_TopPart_TopActionChooseArray_ActionSpace actionTop,
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