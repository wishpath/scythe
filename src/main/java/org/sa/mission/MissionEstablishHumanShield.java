package org.sa.mission;

import org.sa.DTO.PlayerDTO;

public class MissionEstablishHumanShield implements Mission{
  @Override
  public boolean isCompleted(PlayerDTO player) {
    /**
     Have at least 5 workers
     adjacent to Factory
     at the end of your turn
     */
    if (player.workerCount < 5) return false;
    int factoryAdjacentWorkersCount = 0;
    //TODO: iterate player.workers, check Board.isAdjecent(3, 4), countAdjacent++
    return factoryAdjacentWorkersCount >= 5;
  }
}
