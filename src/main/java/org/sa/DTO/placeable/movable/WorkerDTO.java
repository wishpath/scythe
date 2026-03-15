package org.sa.DTO.placeable.movable;

import org.sa.DTO.TileDTO;

public class WorkerDTO implements Movable {
  public TileDTO location;

  public WorkerDTO(TileDTO initialLocation) {
    this.location = initialLocation;
  }

  @Override
  public void moveTo(TileDTO newTileDTO) {
    location = newTileDTO;
  }

  @Override
  public TileDTO getLocation() {
    return location;
  }
}
