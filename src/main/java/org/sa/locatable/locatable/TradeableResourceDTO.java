package org.sa.locatable.locatable;

import org.sa.grid.TileDTO;

public class TradeableResourceDTO implements LocatableResource {
  public final LocatableResourceType locatableResourceType;
  public TileDTO location;

  public TradeableResourceDTO(LocatableResourceType locatableResourceType, TileDTO location) {
    if (locatableResourceType == LocatableResourceType.WORKER) throw new IllegalArgumentException("worker should be WorkerDTO");
    this.locatableResourceType = locatableResourceType;
    this.location = location;
  }

  @Override
  public TileDTO getLocation() {
    return location;
  }

  @Override
  public boolean controlsLocation() {
    return false;
  }

  @Override
  public LocatableResourceType getLocatableResourceType() {
    return locatableResourceType;
  }

  @Override
  public void carryTo(TileDTO targetTile) {
    this.location = targetTile;
  }
}