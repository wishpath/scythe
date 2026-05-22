package org.sa.mission;

import org.sa.DTO.PlayerDTO;
import org.sa.DTO.placeable.movable.WorkerDTO;
import org.sa.enums.locatable_and_grid_enum.TileType;

import java.util.EnumSet;

public class MissionDiversifyProduction implements MissionCard {
  @Override
  public boolean isCompleted(PlayerDTO player) {
    /**
     * Control at least 1 of each primary terrain type
     * with at least 1 worker on each
     * at the end of your turn
    */
    if (player.isEndOfTurn == false || player.placed_workers.size() < 5) return false;
    EnumSet<TileType> controlledTerrainTypes = EnumSet.noneOf(TileType.class);

    for (WorkerDTO worker : player.placed_workers)
      controlledTerrainTypes.add(worker.location.tileType);

    return controlledTerrainTypes.containsAll(TileType.PRIMARY_CONTROLLABLE_TERRAINS);
  }
}
