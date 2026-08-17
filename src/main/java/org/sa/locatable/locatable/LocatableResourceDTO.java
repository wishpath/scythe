package org.sa.locatable.locatable;

import org.sa.grid.TileDTO;

public class LocatableResourceDTO implements LocatableResource {
  public final LocatableResourceType locatableResourceType;
  public TileDTO location;

  public LocatableResourceDTO(LocatableResourceType locatableResourceType, TileDTO location) {
    if (locatableResourceType == LocatableResourceType.WORKER) throw new IllegalArgumentException("worker should be WorkerDTO");
    this.locatableResourceType = locatableResourceType;
    this.location = location;
  }

  @Override
  public TileDTO getLocation() {
    return location;
  }

  @Override
  public LocatableResourceType getLocatableResourceType() {
    return locatableResourceType;
  }
}