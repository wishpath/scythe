package org.sa.player_mat;

import org.sa.player_mat.a_top_parts.enums_and_interfaces.TYPE__TopPart__TopPartChooseActionArray__ActionSpace;
import org.sa.player_mat.a_top_parts.top_part_cost.TopPartCost_0_free;
import org.sa.player_mat.a_top_parts.top_part_cost.TopPartCost_1Coin;
import org.sa.player_mat.a_top_parts.top_part_cost.TopPartCost_Produce;
import org.sa.player_mat.a_top_parts.top_part_upgradable_action.*;
import org.sa.player_mat.a_top_parts.top_part_upgradable_action.interfaces.TopPartUpgradableAction;
import org.sa.player_mat.a_top_parts.top_part_upgradable_action.interfaces.TopPartUpgradableAction_ConcreteDeltaType;
import org.sa.player_mat.bottom_parts.ActionBottom;
import org.sa.state_change_bonus_reward_ability.cost_upgradable.*;

public enum PlayerMat__type_and_structure {
  AGRICULTURAL(
      4,
      7,
      2,
      new ActionSpaceDTO[] {

        // left action space
        new ActionSpaceDTO(
            TYPE__TopPart__TopPartChooseActionArray__ActionSpace.CHOOSE__MOVE__GAIN_COINS, //Action top type
            new TopPartCost_0_free(), //Action top cost: THIS ONE IS FOR FREE
            new TopPartUpgradableAction[]{
                new TopPartUpgradableAction_Move_Decideable(2, 3), //Action top choosable reward
                new TopPartUpgradableAction_Reward_Coins(1, 2) //Action top choosable reward
            },
            ActionBottom.UPGRADE,
            new UpgradableCost_Oil(-2,-2),
            1
        ),


        // mid-left action space
        new ActionSpaceDTO(
            TYPE__TopPart__TopPartChooseActionArray__ActionSpace.CHOOSE__TRADE__GAIN_HEARTS,
            new TopPartCost_1Coin(),
            new TopPartUpgradableAction[]{
              new TopPartUpgradableAction_Hearts(1, 2),
              new TopPartUpgradableAction_Trade_Decideable(2, 2)
            }, //TODO: finish
            ActionBottom.DEPLOY,
            new UpgradableCost_Metal(-4,-2),
            1
        ),


        // mid-right action space
        new ActionSpaceDTO(
            TYPE__TopPart__TopPartChooseActionArray__ActionSpace.NO_CHOOSE__PRODUCE,
            new TopPartCost_Produce(),
            new TopPartUpgradableAction_ConcreteDeltaType[]{

            }, //TODO: finish
            ActionBottom.BUILD,
            new UpgradableCost_Wood(-4,-2),
            1
        ),


        // right action space
        new ActionSpaceDTO(
            TYPE__TopPart__TopPartChooseActionArray__ActionSpace.BOLSTER,
            new TopPartCost_1Coin(),
            new TopPartUpgradableAction_ConcreteDeltaType[]{
              new TopPartUpgradableAction_Attack(2,3),
              new TopPartUpgradableAction_AttackCards(1, 2)
            },
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

