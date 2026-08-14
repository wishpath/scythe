package org.sa.grid;

import org.sa.locatable.locatable.LocatableResourceType;

import java.util.EnumSet;

public enum TileType {

  FORREST_WOOD("Forest", LocatableResourceType.WOOD),
  MOUNTAIN_METAL("Mountain", LocatableResourceType.METAL),
  PLAINS_FOOD("Plains", LocatableResourceType.FOOD),
  TUNDRA_OIL("Tundra", LocatableResourceType.OIL),
  VILLAGE_WORKER("Village", LocatableResourceType.WORKER),
  LAKE("Lake", null),
  CENTER("Factory", null),
  HOME("Home Base", null);

  public final String officialTerrainName;
  public final LocatableResourceType producesResourceType;
  public static final EnumSet<TileType> PRIMARY_CONTROLLABLE_TERRAINS = EnumSet.of(FORREST_WOOD, MOUNTAIN_METAL, PLAINS_FOOD, TUNDRA_OIL, VILLAGE_WORKER);

  TileType(String officialTerrainName, LocatableResourceType produces) {
    this.officialTerrainName = officialTerrainName;
    this.producesResourceType = produces;
  }
}
