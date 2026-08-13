package org.sa.locatable.locatable;

import org.sa.enums.ResourceType;
import org.sa.grid.TileDTO;

public class LocatableResourceDTO implements Locatable {
  public final ResourceType resourceType;
  public TileDTO location;

  public LocatableResourceDTO(ResourceType resourceType, TileDTO location) {
    this.resourceType = resourceType;
    this.location = location;
  }

  @Override
  public TileDTO getLocation() {
    return location;
  }
}