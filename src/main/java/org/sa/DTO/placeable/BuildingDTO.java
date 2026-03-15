package org.sa.DTO.placeable;

import org.sa.DTO.TileDTO;
import org.sa.enums.Building;

public class BuildingDTO implements Locatable {

  public Building buildingType;
  public TileDTO location;     // where the building is placed
  public boolean isBuilt;  // is built on the board

  public BuildingDTO(Building buildingType) {
    this.buildingType = buildingType;
  }

  @Override
  public TileDTO getLocation() {
    return location;
  }
}