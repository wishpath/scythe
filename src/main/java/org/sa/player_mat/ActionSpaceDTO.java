package org.sa.player_mat;

import org.sa.player_mat.a_top_parts.enums_and_interfaces.TYPE__TopPart__TopPartChooseActionArray__ActionSpace;
import org.sa.player_mat.a_top_parts.top_part_cost.TopPartCost;
import org.sa.player_mat.a_top_parts.top_part_upgradable_action.interfaces.TopPartUpgradableAction;
import org.sa.player_mat.bottom_parts.ActionBottom;
import org.sa.state_change_bonus_reward_ability.cost_upgradable.UpgradableCost;
import org.sa.state_change_bonus_reward_ability.reward_basic.ElistActionOneTimeReward_FromFactionMat_Coins;

//contains state, upgradable, through the game
public class ActionSpaceDTO {

  //TODO: each reward (pay or get) should have int amount (state) (upgradable) (initial) (max)
  public TYPE__TopPart__TopPartChooseActionArray__ActionSpace actionTop;
  public TopPartCost actionTopCost;
  public TopPartUpgradableAction[] actionTop_Rewards_toChoose_upgradable;

  ActionBottom actionBottom;
  public UpgradableCost actionBottomUpgradableCost;
  public ElistActionOneTimeReward_FromFactionMat_Coins actionBottomCoinReward;

  public ActionSpaceDTO(
      TYPE__TopPart__TopPartChooseActionArray__ActionSpace actionTop,
      TopPartCost actionTopCost,
      TopPartUpgradableAction[] actionTopRewards_toPickFrom,

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