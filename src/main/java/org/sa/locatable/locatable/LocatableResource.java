package org.sa.locatable.locatable;

import org.sa.grid.TileDTO;

public interface LocatableResource extends Locatable{
  LocatableResourceType getLocatableResourceType();

  void carryTo(TileDTO targetTile);
}
