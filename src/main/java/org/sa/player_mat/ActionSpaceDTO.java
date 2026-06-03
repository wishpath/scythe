package org.sa.player_mat;

import org.sa.player_mat.a_top_parts.enums_and_interfaces.TYPE__TopPart__TopPartChooseActionArray__ActionSpace;
import org.sa.player_mat.a_top_parts.enums_and_interfaces.TopPart;
import org.sa.player_mat.bottom_parts.TYPE__BottomPart__BottomPartAction;
import org.sa.state_change_bonus_reward_ability.cost_upgradable.UpgradableCost;
import org.sa.state_change_bonus_reward_ability.reward_basic.ElistActionOneTimeReward_FromFactionMat_Coins;

//contains state, upgradable, through the game
public class ActionSpaceDTO {

  //TODO: each reward (pay or get) should have int amount (state) (upgradable) (initial) (max)
  public TYPE__TopPart__TopPartChooseActionArray__ActionSpace tYPE__TopPart__TopPartChooseActionArray__ActionSpace;
  public TopPart topPartObject;

  TYPE__BottomPart__BottomPartAction TYPEBottomPartBottomPartAction;
  public UpgradableCost actionBottomUpgradableCost;
  public ElistActionOneTimeReward_FromFactionMat_Coins actionBottomCoinReward;

  public ActionSpaceDTO(
      TYPE__TopPart__TopPartChooseActionArray__ActionSpace topPart_TYPE__actionSpace_TYPE__chooseActionArray_TYPE,
      TopPart topPartObject,

      TYPE__BottomPart__BottomPartAction TYPEBottomPartBottomPartAction,
      UpgradableCost actionBottomUpgradableCost,
      int actionBottomCoinRewardDeltaCoins
  ) {

    this.tYPE__TopPart__TopPartChooseActionArray__ActionSpace = topPart_TYPE__actionSpace_TYPE__chooseActionArray_TYPE;
    this.topPartObject = topPartObject;

    this.TYPEBottomPartBottomPartAction = TYPEBottomPartBottomPartAction;
    this.actionBottomUpgradableCost = actionBottomUpgradableCost;
    this.actionBottomCoinReward = new ElistActionOneTimeReward_FromFactionMat_Coins(actionBottomCoinRewardDeltaCoins);
  }
}