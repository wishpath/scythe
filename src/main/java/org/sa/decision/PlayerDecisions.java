package org.sa.decision;

import org.sa.CardPool;
import org.sa.PlayerDTO;
import org.sa.decision.helper.NotMovedHandler;
import org.sa.faction_mat.FactionMat;
import org.sa.grid.Grid;
import org.sa.grid.TileDTO;
import org.sa.locatable.locatable.BuildingType;
import org.sa.locatable.locatable.LocatableResourceType;
import org.sa.locatable.locatable.TokenDTO;
import org.sa.locatable.locatable.TradeableResourceDTO;
import org.sa.locatable.movable.Movable;
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

import java.util.*;

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



    /**EXAMPLE of MOVE_GAIN********************************************************************************************/
    TYPE_TopPart_ActionSpace move_gain = TYPE_TopPart_ActionSpace.CHOOSE__MOVE__GAIN_COINS; //TODO: player picks this from actionSpacePool
    TopPart topPart_MOVE_GAIN = getTopPartObject(player, move_gain);
    if (topPart_MOVE_GAIN.getCost().hasPlayerResourcesToPayForThisTopPart(player)) {
      boolean playerDecidedToUseTopAction = true; //TODO: player decides if he plays TopPart
      if (playerDecidedToUseTopAction) {
        int picked_reward_index__representing_MOVE = 0; //TODO: player picks index (0 for move and 1 for gain coins) (from choosable actions)
        applyTopAction(player, picked_reward_index__representing_MOVE, topPart_MOVE_GAIN); //player decides what and where to MOVE
      }
      player.isEndOfTurn = true; // finish turn
      player.previousActionSpace = move_gain; // remember completed action
    }
    /**EXAMPLE of PRODUCE**********************************************************************************************/
    TYPE_TopPart_ActionSpace produce = TYPE_TopPart_ActionSpace.NO_CHOOSE__PRODUCE; //TODO: player should pick this from actionSpacePool
    TopPart topPart_PRODUCE = getTopPartObject(player, produce);
    if (topPart_PRODUCE.getCost().hasPlayerResourcesToPayForThisTopPart(player)) {
      boolean playerDecidedToUseTopAction = true; //TODO: player decides if he plays TopPart
      if (playerDecidedToUseTopAction) {
        int picked_reward_index__representing_PRODUCE = 0; //TODO: player picks index, but in this case, only index 0 is available
        applyTopAction(player, picked_reward_index__representing_PRODUCE, topPart_PRODUCE); //player decides what and where to PRODUCE
      }
      player.isEndOfTurn = true; // finish turn
      player.previousActionSpace = produce; // remember completed action
    }
    /**EXAMPLE of TRADE_GAIN*******************************************************************************************/
    TYPE_TopPart_ActionSpace trade = TYPE_TopPart_ActionSpace.CHOOSE__TRADE__GAIN_HEARTS; //TODO: player should pick this from actionSpacePool
    TopPart topPart_TRADE_GAIN = getTopPartObject(player, trade);
    if (topPart_TRADE_GAIN.getCost().hasPlayerResourcesToPayForThisTopPart(player)) {
      boolean playerDecidedToUseTopAction = true; //TODO: player decides if he plays TopPart
      if (playerDecidedToUseTopAction) {
        int picked_reward_index__representing_TRADE = 1; //TODO: player picks index, but in this case, only index 0 is available
        applyTopAction(player, picked_reward_index__representing_TRADE, topPart_TRADE_GAIN); //player decides what and where to TRADE
      }
      player.isEndOfTurn = true; // finish turn
      player.previousActionSpace = trade; // remember completed action
    }
  }



  /**HELPER METHODS****************************************************************************************************/
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
    TopPartUpgradableAction pickedAction = topPart.getTopPartChoosableActions()[pickedActionArrayIndex]; // get action e.g. PRODUCE or MOVE etc, as it picked already

    switch (pickedAction.getDecisionType()) {
      case TopPartDecision_TYPE_ENUM.MOVE -> DECIDE_andApply_TopAction_MOVE((TopPartUpgradableAction_Move_Decideable) pickedAction, player); //cast to MOVE class
      case TopPartDecision_TYPE_ENUM.PRODUCE -> DECIDE_andApply_TopAction_PRODUCE((TopPartUpgradableAction_Produce_Decideable) pickedAction, player); //cast to PRODUCE class
      case TopPartDecision_TYPE_ENUM.TRADE -> DECIDE_andApply_TopAction_TRADE((TopPartUpgradableAction_Trade_Decideable) pickedAction, player); //cast to TRADE class
      case TopPartDecision_TYPE_ENUM.NONE -> ((TopPartUpgradableAction_ConcreteDeltaType) pickedAction).applyToPlayer(player); //case when decision is not needed, simply apply
      default -> throw new IllegalStateException("UNEXPECTED DECISION TYPE: " + pickedAction.getDecisionType());
    };

    //TODO: check if any missions has been completed
  }

  private static void DECIDE_andApply_TopAction_MOVE(TopPartUpgradableAction_Move_Decideable moveAction, PlayerDTO player) {
    int moveCountTotal = moveAction.getCurrentChangeDelta();
    List<Movable> movablesPool = new ArrayList<>(player.getPlacedMovables()); // new list but references same objects

    for (int moveCount = 0; moveCount < moveCountTotal && movablesPool.size() > 0; moveCount++) {
      //decide who moves
      int userPicked_mainMovableIndex = new Random().nextInt(movablesPool.size()); // todo: PLAYER DECIDES main movable
      Movable userPicked_mainMovable = movablesPool.remove(userPicked_mainMovableIndex);
      TileDTO initialLocation = userPicked_mainMovable.getLocation();
      List<Movable> groupOfMovablesDecidedToMove = new ArrayList<>(List.of(userPicked_mainMovable)); //includes main movable
      if (userPicked_mainMovable.isMech()) { //mechs can always carry workers
        TileDTO mechLocation = userPicked_mainMovable.getLocation();
        List<Movable> workersInMechLocation = movablesPool.stream().filter(Movable::isWorker).filter(worker -> worker.getLocation() == mechLocation).toList(); //creates different list, but objects reference matching references
        int playerPicked_workersCountToMoveTogether = workersInMechLocation.size();//todo: PLAYER DECIDES how many workers go together
        for (int j = 0; j < playerPicked_workersCountToMoveTogether; j++) {
          Movable worker = workersInMechLocation.get(j);
          groupOfMovablesDecidedToMove.add(worker);
          movablesPool.remove(worker);
        }
      }

      //decide where to move
      Set<TileDTO> possibleTargets = Grid.getTilesToMoveTo(userPicked_mainMovable, player); //TODO: get list of available Tiles to go to and PLAYER SHOULD PICK ONE
      if (possibleTargets.size() == 0) { //main movable has nowhere to go
        NotMovedHandler.returnOrForgetMovables(player, groupOfMovablesDecidedToMove, userPicked_mainMovable, movablesPool);
        moveCount--; // not counting this iteration as move;
        continue; // no need/ impossible to pick targetTile and complete move
      }

      //move
      TileDTO targetTile = possibleTargets.iterator().next(); //TODO: player picks target tile
      for (Movable movable : groupOfMovablesDecidedToMove) movable.moveTo(targetTile, player); //execute move (considered as one move)

      //carry tradeable resources // !!! this part should stay AFTER move because of "hasMovables" check.
      if (!player.hasLocationAtLeast2Fighters(initialLocation)) {
        if (userPicked_mainMovable.isCharacter() || userPicked_mainMovable.isCharacter() || !player.hasMovables(initialLocation)) { //there are no such rules in the game but let's keep this part simple as this is quite logical
          List<TradeableResourceDTO> resourcesToCarry = player.getTradeableResources(initialLocation);
          for (TradeableResourceDTO resource : resourcesToCarry) resource.carryTo(targetTile);
        }
      }

      //after move effects
      player.isRightAfterMove = true;
      if (player.GREEN_ALBION_flagTokenPool_exalt > 0 && player.isRightAfterMove && userPicked_mainMovable.isCharacter() && !player.hasTileAToken(targetTile)) {
        boolean decidedPlayerToPlaceToken = true; //TODO: player decides
        if (decidedPlayerToPlaceToken) {
          player.locatables.add(new TokenDTO(player, userPicked_mainMovable));
          player.GREEN_ALBION_flagTokenPool_exalt--;
        }
      }
      player.isRightAfterMove = false;

      //fight
      //TODO: fight
      //TODO: when player brings resources to the fight, but looses the fight, will the opponent take re resources?
    }
  }

  private static void DECIDE_andApply_TopAction_PRODUCE(TopPartUpgradableAction_Produce_Decideable produceAction, PlayerDTO player) {
    //how many tiles can produce? //workers (defined in the player mat)
    int countOfProducingTiles = produceAction.currentLimit_amountOfTilesThatCanProduce;

    //which tiles can produce //having workers (not including mill)
    Set<Map.Entry<TileDTO, Integer>> workerTile_produceAmount = player.getProducingTilesMappedToWorkerCount().entrySet();
    int countOfAlreadyProduced = 0;

    //produce from workerTile
    for (Map.Entry<TileDTO, Integer> entry : workerTile_produceAmount) { //TODO: player picks producing tiles
      TileDTO tile = entry.getKey();
      LocatableResourceType resourceType = tile.tileType.producesResourceType;
      if (resourceType == null) throw new IllegalStateException("at this point tile should be producing some resource");
      int amount = entry.getValue();
      player.addLocatableResource(resourceType, amount, tile);
      if (++countOfAlreadyProduced >= countOfProducingTiles) break;
    }

    //produce from mill
    if (player.isBuilt(BuildingType.MILL)) {
      TileDTO millLocation = player.getBuilding(BuildingType.MILL).getLocation();
      LocatableResourceType tradeableResourceOrWorker = millLocation.tileType.producesResourceType;
      if (tradeableResourceOrWorker == null) throw new IllegalStateException("mill is built on a wrong tile type");
      player.addLocatableResource(tradeableResourceOrWorker, 1, millLocation);
    }
    //no after move effects??
    player.isRightAfterMove = true;
    player.isRightAfterMove = false;
  }

  private static void DECIDE_andApply_TopAction_TRADE(TopPartUpgradableAction_Trade_Decideable tradeAction, PlayerDTO player) {
    LocatableResourceType tradeableResourceType1 = LocatableResourceType.getTradeableResourceTypes().get(0); //TODO: player picks resource type1 to get
    LocatableResourceType tradeableResourceType2 = LocatableResourceType.getTradeableResourceTypes().get(0); //TODO: player picks resource type2 to get
    if (tradeableResourceType1 == null || tradeableResourceType2 == null || !tradeableResourceType1.canGetThroughTradeAction || !tradeableResourceType2.canGetThroughTradeAction) throw new IllegalArgumentException("plyer should pick a tradeable resource");
    TileDTO mostPowerfulTileWithWorkers = player.getWorkerTileWithMostPower(); //for the sake of simplicity defining best tile algorithmically. otherwise player could choose.
    player.addTradeableResource(tradeableResourceType1, 1, mostPowerfulTileWithWorkers);
    player.addTradeableResource(tradeableResourceType2, 1, mostPowerfulTileWithWorkers);
    //no after move effects??
    player.isRightAfterMove = true;
    player.isRightAfterMove = false;
  }
}