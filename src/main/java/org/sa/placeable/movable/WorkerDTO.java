package org.sa.placeable.movable;

import org.sa.PlayerDTO;
import org.sa.grid.TileDTO;

public class WorkerDTO implements Movable {
  public TileDTO location;
  public final MovableType type = MovableType.WORKER;

  public WorkerDTO(TileDTO initialLocation) {
    this.location = initialLocation;
  }

  @Override
  public void moveTo(TileDTO targetTile, PlayerDTO player) {
    location = targetTile;
    //todo: if there's an enemy in the target tile then implement war
  }

  @Override
  public MovableType getMovableType() {
    return null;
  }

  @Override
  public boolean isMech() {
    return false;
  }

  @Override
  public boolean isWorker() {
    return true;
  }

  @Override
  public boolean isCharacter() {
    return false;
  }

  @Override
  public TileDTO getLocation() {
    return location;
  }
}
