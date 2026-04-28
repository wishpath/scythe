package org.sa.decision.helper;

import org.sa.DTO.PlayerDTO;
import org.sa.DTO.TileDTO;
import org.sa.DTO.placeable.movable.Movable;
import org.sa.b_storage.Grid;

import java.util.List;
import java.util.Set;

public class NotMovedHandler {

  public static void returnOrForgetMovables(PlayerDTO player, List<Movable> groupOfMovablesDecidedToMove, Movable userPicked_mainMovable, List<Movable> movablesPool) {
    if (groupOfMovablesDecidedToMove.size() == 1) { // so it's main movable only in the group
      if (userPicked_mainMovable.isWorker()) { // single movable is worker (it might get picked by mech)
        if (containsTileMech(userPicked_mainMovable.getLocation(), movablesPool)) { // there is a mech in this single workers tile
          movablesPool.add(userPicked_mainMovable); //maybe mech will bring the worker so lets return worker to the pool
        }
        //else allow loosing this worker from pool, since he cannot go himself and cannot be carried
      }
      //else allow loosing this mech/character from pool, since it has already nowhere to go
    }
    else { //there are many movables so we can assume main movable is mech?
      if (!userPicked_mainMovable.isMech()) throw new IllegalStateException("mech is expected");
      //allow loosing this mech already - but not workers
      if (haveWorkersMoves(groupOfMovablesDecidedToMove, player)) {
        for (Movable movable : groupOfMovablesDecidedToMove) {
          if (movable.isWorker()) movablesPool.add(movable);
        }
      }
    }
  }

  private static boolean haveWorkersMoves(List<Movable> groupOfMovablesDecidedToMove, PlayerDTO player) {
    Movable worker = null;

    for (Movable movable : groupOfMovablesDecidedToMove)
      if (movable.isWorker()) {
        worker = movable;
        break;
      }

    if (worker == null) throw new IllegalArgumentException("AT THIS STAGE A GROUP IS EXPECTED TO CONTAIN A WORKER");
    Set<TileDTO> targetPossibilities = Grid.getTilesToMoveTo(worker, player);

    return targetPossibilities.size() > 0;
  }

  private static boolean containsTileMech(TileDTO location, List<Movable> movablesPool) {
    for (Movable movable : movablesPool)
      if (movable.isMech() && movable.getLocation() == location)
        return true;
    return false;
  }
}
