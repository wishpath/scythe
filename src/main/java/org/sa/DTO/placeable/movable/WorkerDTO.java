package org.sa.DTO.placeable.movable;

import org.sa.DTO.TileDTO;
import org.sa.enums.MovableType;

public class WorkerDTO implements Movable {
  public TileDTO location;
  public final MovableType type = MovableType.WORKER;

  public WorkerDTO(TileDTO initialLocation) {
    this.location = initialLocation;
  }

  @Override
  public void moveTo(TileDTO newTileDTO) {
    location = newTileDTO;
  }

  @Override
  public MovableType getMovableType() {
    return null;
  }

  @Override
  public TileDTO getLocation() {
    return location;
  }
}
