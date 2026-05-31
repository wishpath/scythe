package org.sa.player_mat;

import org.sa.player_mat.a_TOPS.enums_and_interfaces.TYPE_TopPart_TopActionChooseArray_ActionSpace;
import org.sa.player_mat.a_TOPS.upgradable_state_change_top.*;
import org.sa.player_mat.a_TOPS.upgradable_state_change_top.interfaces.UpgradableStateChange_Top;
import org.sa.player_mat.a_TOPS.upgradable_state_change_top.interfaces.UpgradableStateChange_Top_ConcreteDeltaType;
import org.sa.player_mat.b_BOTTOM.ActionBottom;
import org.sa.state_change_bonus_reward_ability.cost_upgradable.*;

public enum PlayerMat__type_and_structure {
  AGRICULTURAL(
      4,
      7,
      2,
      new ActionSpaceDTO[] {

        // left action space
        new ActionSpaceDTO(
            TYPE_TopPart_TopActionChooseArray_ActionSpace.CHOOSE__MOVE__GAIN_COINS, //Action top type
            new UpgradableCost_Coins(0, 0), //Action top cost: THIS ONE IS FOR FREE
            new UpgradableStateChange_Top[]{
                new UpgradableStateChange_Top_Move_Decideable(2, 3), //Action top choosable reward
                new UpgradableStateChange_Top_Reward_Coins(1, 2) //Action top choosable reward
            },
            ActionBottom.UPGRADE,
            new UpgradableCost_Oil(-2,-2),
            1
        ),


        // mid-left action space
        new ActionSpaceDTO(
            TYPE_TopPart_TopActionChooseArray_ActionSpace.CHOOSE__TRADE__GAIN_HEARTS,
            new UpgradableCost_Coins(1, 1),
            new UpgradableStateChange_Top[]{
              new UpgradableStateChange_Top_Hearts(1, 2),
              new UpgradableStateChange_Top_Trade_Decideable(2, 2)
            }, //TODO: finish
            ActionBottom.DEPLOY,
            new UpgradableCost_Metal(-4,-2),
            1
        ),


        // mid-right action space
        new ActionSpaceDTO(
            TYPE_TopPart_TopActionChooseArray_ActionSpace.NO_CHOOSE__PRODUCE,
            new UpgradableCost_Produce(),
            new UpgradableStateChange_Top_ConcreteDeltaType[]{

            }, //TODO: finish
            ActionBottom.BUILD,
            new UpgradableCost_Wood(-4,-2),
            1
        ),


        // right action space
        new ActionSpaceDTO(
            TYPE_TopPart_TopActionChooseArray_ActionSpace.BOLSTER,
            new UpgradableCost_Coins(1, 1),
            new UpgradableStateChange_Top_ConcreteDeltaType[]{
              new UpgradableStateChange_Top_Attack(2,3),
              new UpgradableStateChange_Top_AttackCards(1, 2)
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

