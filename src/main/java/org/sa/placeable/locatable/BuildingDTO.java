package org.sa.placeable.locatable;

import org.sa.grid.TileDTO;

public class BuildingDTO implements Locatable {

  public BuildingType buildingType;
  public TileDTO location;     // where the building is placed

  public BuildingDTO(BuildingType buildingType) {
    this.buildingType = buildingType;
  }

  @Override
  public TileDTO getLocation() {
    return location;
  }
}