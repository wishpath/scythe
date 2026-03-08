package org.sa.DTO;

import org.sa.enums.Building;

public class BuildingDTO {

  public Building buildingType;
  public TileDTO location;     // where the building is placed
  public boolean isBuilt;  // is built on the board

  public BuildingDTO(Building buildingType) {
    this.buildingType = buildingType;
  }
}