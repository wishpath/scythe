package org.sa.mission;

import org.sa.PlayerDTO;
import org.sa.placeable.movable.WorkerDTO;
import org.sa.grid.Grid;

public class MissionEstablishHumanShield implements MissionCard {
  @Override
  public boolean isCompleted(PlayerDTO player) {
    /**
     Have at least 5 workers
     adjacent to Factory
     at the end of your turn
     */
    if (player.isEndOfTurn == false) return false;
    if (player.placed_workers.size() < 5) return false;
    int factoryAdjacentWorkersCount = 0;

    for (WorkerDTO worker : player.placed_workers)
      if (Grid.isItemAdjacent(Grid.CENTER_FACTORY, worker.location))
        factoryAdjacentWorkersCount++;

    return factoryAdjacentWorkersCount >= 5;
  }
}
