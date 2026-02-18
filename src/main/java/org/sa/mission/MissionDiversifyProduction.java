package org.sa.mission;

import org.sa.DTO.PlayerDTO;
import org.sa.DTO.WorkerDTO;
import org.sa.enums.TileType;

import java.util.EnumSet;

public class MissionDiversifyProduction implements MissionCard {
  @Override
  public boolean isCompleted(PlayerDTO player) {
    /**
     * Control at least 1 of each primary terrain type
     * with at least 1 worker on each
     * at the end of your turn
    */
    if (player.isEndOfTurn == false || player.workers.size() < 5) return false;
    EnumSet<TileType> controlledTerrainTypes = EnumSet.noneOf(TileType.class);

    for (WorkerDTO worker : player.workers)
      controlledTerrainTypes.add(worker.location.tileType);

    return controlledTerrainTypes.containsAll(TileType.PRIMARY_TERRAINS);
  }
}
