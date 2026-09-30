package org.sa.mission;

import org.sa.PlayerDTO;
import org.sa.locatable.movable.WorkerDTO;
import org.sa.grid.Grid;

public class MissionEstablishHumanShield implements MissionCard {
  @Override
  public boolean isCompleted(PlayerDTO player) {
    /**
     Have at least 5 workers
     adjacent to Factory
     at the end of player's turn
     */
    if (player.isPlayersTurn == true) return false; // is not at the end of player's turn
    if (player.getPlacedWorkers().size() < 5) return false;
    int factoryAdjacentWorkersCount = 0;

    for (WorkerDTO worker : player.getPlacedWorkers())
      if (Grid.isItemAdjacent(Grid.CENTER_FACTORY, worker.location))
        factoryAdjacentWorkersCount++;

    return factoryAdjacentWorkersCount >= 5;
  }
}
