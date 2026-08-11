package org.sa.grid;

import org.sa.enums.ResourceType;

import java.util.EnumSet;

public enum TileType {

  FORREST_WOOD("Forest", ResourceType.WOOD),
  MOUNTAIN_METAL("Mountain", ResourceType.METAL),
  PLAINS_FOOD("Plains", ResourceType.FOOD),
  TUNDRA_OIL("Tundra", ResourceType.OIL),
  VILLAGE_WORKER("Village", ResourceType.WORKERS),
  LAKE("Lake", null),
  CENTER("Factory", null),
  HOME("Home Base", null);

  public final String officialTerrainName;
  public final ResourceType producesResourceType;
  public static final EnumSet<TileType> PRIMARY_CONTROLLABLE_TERRAINS = EnumSet.of(FORREST_WOOD, MOUNTAIN_METAL, PLAINS_FOOD, TUNDRA_OIL, VILLAGE_WORKER);

  TileType(String officialTerrainName, ResourceType produces) {
    this.officialTerrainName = officialTerrainName;
    this.producesResourceType = produces;
  }
}
