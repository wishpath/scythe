package org.sa.grid.placeable;

import org.sa.grid.TileDTO;
import org.sa.enums.BuildingType;

public class BuildingDTO implements Locatable {

  public BuildingType buildingType;
  public TileDTO location;     // where the building is placed
  public boolean isBuilt;  // is built on the board

  public BuildingDTO(BuildingType buildingType) {
    this.buildingType = buildingType;
  }

  @Override
  public TileDTO getLocation() {
    return location;
  }
}