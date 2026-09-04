package org.sa.decision;

import org.sa.CardPool;
import org.sa.PlayerDTO;
import org.sa.decision.helper.Helper_MOVE;
import org.sa.decision.helper.Helper_PRODUCE;
import org.sa.decision.helper.Helper_TRADE;
import org.sa.faction_mat.FactionMat;
import org.sa.grid.Grid;
import org.sa.grid.TileDTO;
import org.sa.locatable.movable.WorkerDTO;
import org.sa.player_mat.ActionSpaceDTO;
import org.sa.player_mat.PlayerMatDTO;
import org.sa.player_mat.a_top_parts.enums_and_interfaces.TYPE_TopPart_ActionSpace;
import org.sa.player_mat.a_top_parts.enums_and_interfaces.TopPart;
import org.sa.player_mat.a_top_parts.enums_and_interfaces.TopPartDecision_TYPE_ENUM;
import org.sa.player_mat.a_top_parts.top_part_upgradable_action.TopPartUpgradableAction_Move_Decideable;
import org.sa.player_mat.a_top_parts.top_part_upgradable_action.TopPartUpgradableAction_Produce_Decideable;
import org.sa.player_mat.a_top_parts.top_part_upgradable_action.TopPartUpgradableAction_Trade_Decideable;
import org.sa.player_mat.a_top_parts.top_part_upgradable_action.interfaces.TopPartUpgradableAction;
import org.sa.player_mat.a_top_parts.top_part_upgradable_action.interfaces.TopPartUpgradableAction_ConcreteDeltaType;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class PlayerDecisions {
  private static final int INITIAL_WORKERS_COUNT = 2;

  public static void main(String[] args) {

    /**INITIALISE PLAYER AND INITIAL DETAILS***************************************************************************/
    FactionMat factionMat = CardPool.drawEnlistCard(); //player draws Faction Mat (color)
    PlayerMatDTO playerMat = CardPool.drawPlayerMat(); //player draws Player Mat (not connected to faction)
    List<WorkerDTO> workers = new ArrayList<>(INITIAL_WORKERS_COUNT);
    for (int i = 0; i < INITIAL_WORKERS_COUNT; i++) {
      Set<TileDTO> nearHomeTiles = Grid.getNonNullNeighborsNotSelf(factionMat.homeTile);
      workers.add(new WorkerDTO(nearHomeTiles.iterator().next())); //TODO: player should pick where to place each worker
    }
    PlayerDTO player = new PlayerDTO(playerMat, factionMat, workers);
    player.isEndOfTurn = false; // there comes a players turn to play


    /******************************************************************************************************************/
    /** TOP ACTIONS WITH DECISIONS ************************************************************************************/
    /******************************************************************************************************************/


    /** EXAMPLE of MOVE_GAIN ******************************************************************************************/
    TYPE_TopPart_ActionSpace move_gain = TYPE_TopPart_ActionSpace.CHOOSE__MOVE__GAIN_COINS; //TODO: player picks this from actionSpacePool
    TopPart topPart_MOVE_GAIN = getTopPartObject(player, move_gain);
    if (topPart_MOVE_GAIN.getCost().hasPlayerResourcesToPayForThisTopPart(player)) {
      boolean playerDecidedToUseTopAction = true; //TODO: player decides if he plays TopPart
      if (playerDecidedToUseTopAction) {
        int pickedActionArrayIndex__representing_MOVE = 0; //TODO: player picks index (0 for move and 1 for gain coins) (from choosable actions)
        applyTopAction(player, pickedActionArrayIndex__representing_MOVE, topPart_MOVE_GAIN); //player decides what and where to MOVE
      }
      player.isEndOfTurn = true; // finish turn
      player.previousActionSpace = move_gain; // remember completed action
    }
    /** EXAMPLE of PRODUCE ********************************************************************************************/
    TYPE_TopPart_ActionSpace produce = TYPE_TopPart_ActionSpace.NO_CHOOSE__PRODUCE; //TODO: player should pick this from actionSpacePool
    TopPart topPart_PRODUCE = getTopPartObject(player, produce);
    if (topPart_PRODUCE.getCost().hasPlayerResourcesToPayForThisTopPart(player)) {
      boolean playerDecidedToUseTopAction = true; //TODO: player decides if he plays TopPart
      if (playerDecidedToUseTopAction) {
        int pickedActionArrayIndex__representing_PRODUCE = 0; //TODO: player picks index, but in this case, only index 0 is available
        applyTopAction(player, pickedActionArrayIndex__representing_PRODUCE, topPart_PRODUCE); //player decides what and where to PRODUCE
      }
      player.isEndOfTurn = true; // finish turn
      player.previousActionSpace = produce; // remember completed action
    }
    /** EXAMPLE of TRADE_GAIN *****************************************************************************************/
    TYPE_TopPart_ActionSpace trade = TYPE_TopPart_ActionSpace.CHOOSE__TRADE__GAIN_HEARTS; //TODO: player should pick this from actionSpacePool
    TopPart topPart_TRADE_GAIN = getTopPartObject(player, trade);
    if (topPart_TRADE_GAIN.getCost().hasPlayerResourcesToPayForThisTopPart(player)) {
      boolean playerDecidedToUseTopAction = true; //TODO: player decides if he plays TopPart
      if (playerDecidedToUseTopAction) {
        int pickedActionArrayIndex__representing_TRADE = 1; //TODO: player picks index, but in this case, only index 0 is available
        applyTopAction(player, pickedActionArrayIndex__representing_TRADE, topPart_TRADE_GAIN); //player decides what and where to TRADE
      }
      player.isEndOfTurn = true; // finish turn
      player.previousActionSpace = trade; // remember completed action
    }


    /******************************************************************************************************************/
    /** TOP ACTIONS — TopPartDecision_TYPE_ENUM.NONE ******************************************************************/
    /******************************************************************************************************************/

    /** EXAMPLE of BOLSTER (get attack) *******************************************************************************/
    TYPE_TopPart_ActionSpace bolsterPower = TYPE_TopPart_ActionSpace.CHOOSE__POWER__COMBAT_CARDS; //TODO: player should pick this from actionSpacePool
    TopPart topPart_BolsterPower = getTopPartObject(player, bolsterPower);
    if (topPart_BolsterPower.getCost().hasPlayerResourcesToPayForThisTopPart(player)) {
      boolean playerDecidedToUseTopAction = true; //TODO: player decides if he plays TopPart
      if (playerDecidedToUseTopAction) {
        int pickedActionArrayIndex__representing_GAIN_ATTACK = 0; //TODO: player picks index, but in this case, only index 0 is available
        applyTopAction(player, pickedActionArrayIndex__representing_GAIN_ATTACK, topPart_BolsterPower); //player decides what and where to TRADE
      }}
    player.isEndOfTurn = true; // finish turn
    player.previousActionSpace = trade; // remember completed action
    /** EXAMPLE of BOLSTER (get attack cards) *************************************************************************/
    TYPE_TopPart_ActionSpace bolsterPower2 = TYPE_TopPart_ActionSpace.CHOOSE__POWER__COMBAT_CARDS; //TODO: player should pick this from actionSpacePool
    TopPart topPart_BolsterPower2 = getTopPartObject(player, bolsterPower);
    if (topPart_BolsterPower2.getCost().hasPlayerResourcesToPayForThisTopPart(player)) {
      boolean playerDecidedToUseTopAction = true; //TODO: player decides if he plays TopPart
      if (playerDecidedToUseTopAction) {
        int pickedActionArrayIndex__representing_GAIN_ATTACK_CARDS = 1; //TODO: player picks index, but in this case, only index 0 is available
        applyTopAction(player, pickedActionArrayIndex__representing_GAIN_ATTACK_CARDS, topPart_BolsterPower2); //player decides what and where to TRADE
      }}
    player.isEndOfTurn = true; // finish turn
    player.previousActionSpace = trade; // remember completed action
    /** EXAMPLE of MOVE_GAIN (get coins) ******************************************************************************/
    /** EXAMPLE of TRADE_GAIN (get popularity-hearts) *****************************************************************/
  }


  /********************************************************************************************************************/
  /** HELPER METHODS **************************************************************************************************/
  /********************************************************************************************************************/

  private static TopPart getTopPartObject(PlayerDTO player, TYPE_TopPart_ActionSpace pickedTopPartType) {
    EnumSet<TYPE_TopPart_ActionSpace> actionSpacePool = EnumSet.allOf(TYPE_TopPart_ActionSpace.class);
    if (player.previousActionSpace != null && !player.RED_RUSVIET_canChooseSameActionSpaceEveryTurn_relentless) {
      if (player.factionMat == player.factionMat.RED) throw new IllegalStateException("this should not happen for RED (rusviet)");
      actionSpacePool.remove(player.previousActionSpace);
    }
    ActionSpaceDTO pickedActionSpaceDTO = player.playerMat.actionSpaceType_actionSpaceDTO.get(pickedTopPartType);
    return pickedActionSpaceDTO.topPartObject; // top part type matches action space
  }
  private static void applyTopAction(PlayerDTO player, int pickedActionArrayIndex, TopPart topPart) {
    topPart.getCost().applyToPlayer(player); // pay for top action
    topPart.rewardPlayerWithBuildingRelatedIntResourceIfApplicable(player);
    TopPartUpgradableAction pickedAction = topPart.getTopPartChoosableActions()[pickedActionArrayIndex]; // get action e.g. PRODUCE or MOVE etc, as it picked already

    switch (pickedAction.getDecisionType()) {
      case TopPartDecision_TYPE_ENUM.MOVE -> Helper_MOVE.DECIDE_andApply_TopAction_MOVE((TopPartUpgradableAction_Move_Decideable) pickedAction, player); //cast to MOVE class
      case TopPartDecision_TYPE_ENUM.PRODUCE -> Helper_PRODUCE.DECIDE_andApply_TopAction_PRODUCE((TopPartUpgradableAction_Produce_Decideable) pickedAction, player); //cast to PRODUCE class
      case TopPartDecision_TYPE_ENUM.TRADE -> Helper_TRADE.DECIDE_andApply_TopAction_TRADE((TopPartUpgradableAction_Trade_Decideable) pickedAction, player); //cast to TRADE class
      case TopPartDecision_TYPE_ENUM.NONE -> ((TopPartUpgradableAction_ConcreteDeltaType) pickedAction).applyToPlayer(player); //case when decision is not needed, simply apply
      default -> throw new IllegalStateException("UNEXPECTED DECISION TYPE: " + pickedAction.getDecisionType());
    };

    //TODO: check if any missions has been completed
  }
}