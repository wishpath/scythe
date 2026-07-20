package org.sa.placeable.locatable;

import org.sa.grid.TileDTO;

public class BuildingDTO implements Locatable {

  public BuildingType buildingType;
  public TileDTO location;     // where the building is placed

  public BuildingDTO(BuildingType buildingType, TileDTO location) {
    this.buildingType = buildingType;
    this.location = location;
  }

  @Override
  public TileDTO getLocation() {
    return location;
  }
}