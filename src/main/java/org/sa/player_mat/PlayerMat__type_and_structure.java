package org.sa.player_mat;

import org.sa.player_mat.a_top_parts.TopPart_chooseBetweenAttack_PointsOrCards;
import org.sa.player_mat.a_top_parts.TopPart_chooseBetweenMoveOrGainCoins;
import org.sa.player_mat.a_top_parts.TopPart_chooseBetweenTradeGoodsOrGainHearts;
import org.sa.player_mat.a_top_parts.TopPart_noChoosing_Produce;
import org.sa.player_mat.a_top_parts.enums_and_interfaces.TYPE__TopPart__TopPartChooseActionArray__ActionSpace;
import org.sa.player_mat.bottom_parts.ActionBottom;
import org.sa.state_change_bonus_reward_ability.cost_upgradable.UpgradableCost_Food;
import org.sa.state_change_bonus_reward_ability.cost_upgradable.UpgradableCost_Metal;
import org.sa.state_change_bonus_reward_ability.cost_upgradable.UpgradableCost_Oil;
import org.sa.state_change_bonus_reward_ability.cost_upgradable.UpgradableCost_Wood;

public enum PlayerMat__type_and_structure {
  AGRICULTURAL(
      4,
      7,
      2,
      new ActionSpaceDTO[] {

        // left action space
        new ActionSpaceDTO(
            TYPE__TopPart__TopPartChooseActionArray__ActionSpace.CHOOSE__MOVE__GAIN_COINS, //Action top type
            new TopPart_chooseBetweenMoveOrGainCoins(),
            ActionBottom.UPGRADE,
            new UpgradableCost_Oil(-2,-2),
            1
        ),

        // mid-left action space
        new ActionSpaceDTO(
            TYPE__TopPart__TopPartChooseActionArray__ActionSpace.CHOOSE__TRADE__GAIN_HEARTS,
            new TopPart_chooseBetweenTradeGoodsOrGainHearts(),
            ActionBottom.DEPLOY,
            new UpgradableCost_Metal(-4,-2),
            1
        ),


        // mid-right action space
        new ActionSpaceDTO(
            TYPE__TopPart__TopPartChooseActionArray__ActionSpace.NO_CHOOSE__PRODUCE,
            new TopPart_noChoosing_Produce(),
            ActionBottom.BUILD,
            new UpgradableCost_Wood(-4,-2),
            1
        ),


        // right action space
        new ActionSpaceDTO(
            TYPE__TopPart__TopPartChooseActionArray__ActionSpace.CHOOSE__POWER__COMBAT_CARDS,
            new TopPart_chooseBetweenAttack_PointsOrCards(),
            ActionBottom.ENLIST,
            new UpgradableCost_Food(-3,-1),
            1
        ),
      }
  ),

  //TODO: finish up entering initialActionSpaces[]
  ENGINEERING(-1, -1, -1,  new ActionSpaceDTO[4]),
  INDUSTRIAL( -1, -1, -1,   new ActionSpaceDTO[4]), //TODO: finish
  INNOVATIVE( -1, -1, -1,  new ActionSpaceDTO[4]), //TODO: finish
  MECHANICAL( -1, -1, -1,  new ActionSpaceDTO[4]), //TODO: finish
  MILITANT( -1, -1, -1,  new ActionSpaceDTO[4]), //TODO: finish
  PATRIOTIC( -1, -1, -1,  new ActionSpaceDTO[4]); //TODO: finish

  public final int initialHearts;
  public final int initialCoins;
  public final int initialMissionCards;
  public ActionSpaceDTO[] initialActionSpaces; // those 4 sections //TODO: how does it work when additional is added from the center tile

  PlayerMat__type_and_structure(
      int initialHearts,
      int initialCoins,
      int initialMissionCards,
      ActionSpaceDTO[] initialActionSpaces
  ) {
    this.initialHearts = initialHearts;
    this.initialCoins = initialCoins;
    this.initialMissionCards = initialMissionCards;
    this.initialActionSpaces = initialActionSpaces;
  }
}

