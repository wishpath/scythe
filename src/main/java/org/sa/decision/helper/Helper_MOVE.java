package org.sa.decision.helper;

import org.sa.PlayerDTO;
import org.sa.grid.Grid;
import org.sa.grid.TileDTO;
import org.sa.locatable.locatable.TokenDTO;
import org.sa.locatable.locatable.TradeableResourceDTO;
import org.sa.locatable.movable.Movable;
import org.sa.player_mat.a_top_parts.top_part_upgradable_action.TopPartUpgradableAction_Move_Decideable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Helper_MOVE {
  public static void DECIDE_andApply_TopAction_MOVE(TopPartUpgradableAction_Move_Decideable moveAction, PlayerDTO player) {
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
}
