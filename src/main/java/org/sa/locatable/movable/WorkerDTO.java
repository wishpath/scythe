package org.sa.locatable.movable;

import org.sa.PlayerDTO;
import org.sa.grid.TileDTO;
import org.sa.locatable.locatable.LocatableResource;
import org.sa.locatable.locatable.LocatableResourceType;

public class WorkerDTO implements Movable, LocatableResource {
  public TileDTO location;
  public final MovableType movableType = MovableType.WORKER;
  public final LocatableResourceType locatableResourceType = LocatableResourceType.WORKER;

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

  @Override
  public LocatableResourceType getLocatableResourceType() {
    return this.locatableResourceType;
  }
}
