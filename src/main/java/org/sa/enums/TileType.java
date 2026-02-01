package org.sa.enums;
import java.util.EnumSet;

public enum TileType {

  WOOD("Forest"),
  METAL("Mountain"),
  FOOD("Plains"),
  OIL("Tundra"),
  WORKER("Village"),
  WATER("Lake"),
  CENTER("Factory"),
  HOME("Home Base");

  public final String officialTerrainName;
  public static final EnumSet<TileType> PRIMARY_TERRAINS = EnumSet.of(WOOD, METAL, FOOD, OIL, WORKER);

  TileType(String officialTerrainName) {
    this.officialTerrainName = officialTerrainName;
  }
}
