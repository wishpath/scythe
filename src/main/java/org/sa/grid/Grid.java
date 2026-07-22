package org.sa.grid;

import org.sa.PlayerDTO;
import org.sa.locatable.locatable.BuildingDTO;
import org.sa.locatable.locatable.TokenDTO;
import org.sa.locatable.movable.Movable;
import org.sa.locatable.movable.WorkerDTO;
import org.sa.locatable.locatable.BuildingType;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Grid {
  public static TileDTO[][] grid = new TileDTO[9][10];
  public static final TileDTO CENTER_FACTORY = new TileDTO(TileType.CENTER, 4, 5);

  static {
    grid[0][5] = new TileDTO(TileType.HOME, 0, 5);
    grid[0][8] = new TileDTO(TileType.METAL, 0, 8);

    grid[1][4] = new TileDTO(TileType.METAL, 1, 4);
    grid[1][5] = new TileDTO(TileType.FOOD, 1, 5);
    grid[1][6] = new TileDTO(TileType.WORKER, 1, 6)
        .setRivers(DirectionType.EAST, DirectionType.SOUTH_EAST);
    grid[1][7] = new TileDTO(TileType.WOOD, 1, 7)
        .setRivers(DirectionType.SOUTH_WEST, DirectionType.WEST);
    grid[1][8] = new TileDTO(TileType.OIL, 1, 8)
        .setRivers(DirectionType.EAST, DirectionType.SOUTH_EAST);
    grid[1][9] = new TileDTO(TileType.WORKER, 1, 9)
        .setRivers(DirectionType.WEST);

    grid[2][3] = new TileDTO(TileType.LAKE, 2, 3);
    grid[2][4] = new TileDTO(TileType.OIL, 2, 4)
        .setRivers(DirectionType.SOUTH_WEST);
    grid[2][5] = new TileDTO(TileType.LAKE, 2, 5);
    grid[2][6] = new TileDTO(TileType.OIL, 2, 6)
        .markAsTunnel()
        .setRivers(DirectionType.NORTH_WEST, DirectionType.NORTH_EAST, DirectionType.EAST);
    grid[2][7] = new TileDTO(TileType.METAL, 2, 7)
        .setRivers(DirectionType.WEST, DirectionType.EAST, DirectionType.SOUTH_EAST);
    grid[2][8] = new TileDTO(TileType.FOOD, 2, 8)
        .setRivers(DirectionType.WEST, DirectionType.NORTH_WEST, DirectionType.SOUTH_EAST);
    grid[2][9] = new TileDTO(TileType.FOOD, 2, 9)
        .setRivers(DirectionType.SOUTH_EAST, DirectionType.SOUTH_WEST);

    grid[3][2] = new TileDTO(TileType.HOME, 3, 2);
    grid[3][3] = new TileDTO(TileType.WOOD, 3, 3)
        .setRivers(DirectionType.NORTH_EAST, DirectionType.EAST);
    grid[3][4] = new TileDTO(TileType.METAL, 3, 4)
        .markAsTunnel()
        .setRivers(DirectionType.WEST, DirectionType.SOUTH_WEST);
    grid[3][5] = new TileDTO(TileType.WOOD, 3, 5);
    grid[3][6] = new TileDTO(TileType.LAKE, 3, 6);
    grid[3][7] = new TileDTO(TileType.WOOD, 3, 7)
        .markAsTunnel()
        .setRivers(DirectionType.NORTH_WEST, DirectionType.EAST, DirectionType.SOUTH_EAST);
    grid[3][8] = new TileDTO(TileType.WORKER, 3, 8)
        .setRivers(DirectionType.WEST, DirectionType.NORTH_WEST, DirectionType.NORTH_EAST);
    grid[3][9] = new TileDTO(TileType.HOME, 3, 9)
        .setRivers(DirectionType.NORTH_WEST);

    grid[4][2] = new TileDTO(TileType.FOOD, 4, 2)
        .setRivers(DirectionType.SOUTH_WEST, DirectionType.SOUTH_EAST);
    grid[4][3] = new TileDTO(TileType.WORKER, 4, 3)
        .setRivers(DirectionType.SOUTH_WEST, DirectionType.SOUTH_EAST, DirectionType.NORTH_EAST);
    grid[4][4] = new TileDTO(TileType.LAKE, 4, 4);
    grid[4][5] = CENTER_FACTORY;
    grid[4][6] = new TileDTO(TileType.METAL, 4, 6)
        .setRivers(DirectionType.EAST);
    grid[4][7] = new TileDTO(TileType.OIL, 4, 7)
        .setRivers(DirectionType.SOUTH_WEST, DirectionType.WEST, DirectionType.NORTH_WEST);
    grid[4][8] = new TileDTO(TileType.METAL, 4, 8);

    grid[5][1] = new TileDTO(TileType.WOOD,  5, 1)
        .setRivers(DirectionType.NORTH_WEST, DirectionType.NORTH_EAST, DirectionType.SOUTH_EAST, DirectionType.SOUTH_WEST);
    grid[5][2] = new TileDTO(TileType.WOOD,  5, 2)
        .setRivers(DirectionType.NORTH_WEST, DirectionType.NORTH_EAST, DirectionType.SOUTH_EAST, DirectionType.SOUTH_WEST);
    grid[5][3] = new TileDTO(TileType.FOOD,  5, 3)
        .markAsTunnel()
        .setRivers(DirectionType.NORTH_WEST, DirectionType.SOUTH_WEST);
    grid[5][4] = new TileDTO(TileType.OIL,  5, 4);
    grid[5][5] = new TileDTO(TileType.LAKE,  5, 5);
    grid[5][6] = new TileDTO(TileType.WORKER,  5, 6)
        .markAsTunnel()
        .setRivers(DirectionType.NORTH_EAST);
    grid[5][7] = new TileDTO(TileType.LAKE,  5, 7);

    grid[6][1] = new TileDTO(TileType.METAL,  6, 1)
        .setRivers(DirectionType.NORTH_WEST, DirectionType.NORTH_EAST);
    grid[6][2] = new TileDTO(TileType.WORKER,  6, 2)
        .setRivers(DirectionType.NORTH_WEST, DirectionType.NORTH_EAST, DirectionType.EAST);
    grid[6][3] = new TileDTO(TileType.WORKER,  6, 3)
        .setRivers(DirectionType.WEST, DirectionType.SOUTH_EAST);
    grid[6][4] = new TileDTO(TileType.OIL,  6, 4)
        .markAsTunnel()
        .setRivers(DirectionType.SOUTH_EAST, DirectionType.SOUTH_WEST);
    grid[6][5] = new TileDTO(TileType.WOOD,  6, 5)
        .setRivers(DirectionType.SOUTH_WEST);
    grid[6][6] = new TileDTO(TileType.METAL,  6, 6);
    grid[6][7] = new TileDTO(TileType.OIL,  6, 7);

    grid[7][0] = new TileDTO(TileType.HOME,  7, 0);
    grid[7][1] = new TileDTO(TileType.OIL,  7, 1);
    grid[7][2] = new TileDTO(TileType.LAKE,  7, 2);
    grid[7][3] = new TileDTO(TileType.FOOD,  7, 3)
        .setRivers(DirectionType.NORTH_WEST, DirectionType.NORTH_EAST);
    grid[7][4] = new TileDTO(TileType.METAL,  7, 4)
        .setRivers(DirectionType.NORTH_WEST, DirectionType.NORTH_EAST, DirectionType.EAST);
    grid[7][5] = new TileDTO(TileType.WORKER,  7, 5)
        .setRivers(DirectionType.WEST);
    grid[7][6] = new TileDTO(TileType.FOOD,  7, 6);
    grid[7][7] = new TileDTO(TileType.HOME,  7, 7);

    grid[8][2] = new TileDTO(TileType.HOME,  8, 2);
    grid[8][3] = new TileDTO(TileType.WORKER,  8, 3);
  }

  private static final Set<TileDTO> tunnels = Arrays.stream(grid).flatMap(Arrays::stream).filter(Objects::nonNull).filter(t -> t.isTunnel).collect(Collectors.toSet());

  public static boolean isItemAdjacent(TileDTO tile, TileDTO itemLocation) {
    for (DirectionType direction : DirectionType.values())
      if (isAdjacentToDirection(tile, direction, itemLocation))
        return true;
    return false;
  }

  public static boolean isAdjacentToDirection(TileDTO tile, DirectionType direction, TileDTO itemLocation) {
    int row = tile.row + direction.deltaRow;
    if (row < 0 || row >= grid.length) return false;
    int column = tile.column + direction.deltaColumn;
    if (column < 0 || column >= grid[0].length) return false;
    TileDTO checkedTile = grid[row][column];
    if (checkedTile == null) return false;
    return checkedTile.equals(itemLocation);
  }

  public static Set<TileDTO> getNonNullNeighborsNotSelf(TileDTO tile) {
    Set<TileDTO> neighbors = new HashSet<>();
    for (DirectionType direction : DirectionType.values()) {
      int row = tile.row + direction.deltaRow;
      if (row < 0 || row >= grid.length) continue;

      int column = tile.column + direction.deltaColumn;
      if (column < 0 || column >= grid[0].length) continue;

      TileDTO neighbor = grid[row][column];
      if (neighbor != null && !neighbor.equals(tile)) neighbors.add(neighbor);
    }
    return neighbors;
  }

  public static TileDTO getNeighborTile_possiblyNull(TileDTO tile, DirectionType direction) {
    int row = tile.row + direction.deltaRow;
    int col = tile.column + direction.deltaColumn;
    if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return null;
    return grid[row][col];
  }

  public static Set<TileDTO> getTilesToMoveTo(Movable movable, PlayerDTO player) {
    TileDTO tileFrom = movable.getLocation();
    Set<TileDTO> validDestinationTiles = new HashSet<>();

    //deal neighboring tiles
    for (DirectionType direction : DirectionType.values()) { //includes direction Direction.THIS
      TileDTO tileTo = getNeighborTile_possiblyNull(tileFrom, direction); //possibly self
      if (tileTo == null) continue;
      if (tileTo.tileType.equals(TileType.LAKE)) continue;

      //deal river
      if (tileFrom.hasRiverInTheDirection(direction)) {
        if (player.GREEN_ALBION_mechAndCharacter_canCrossRiverToOrFromTunnel_burrow && (movable.isCharacter() || movable.isMech())) {
          if (tileFrom.isTunnel || tileTo.isTunnel) validDestinationTiles.add(tileTo);
          else continue;
        }
        else continue;
      }
    }

    //deal tunnels
    if (tileFrom.isTunnel || hasTileMine(tileFrom, player)) {
      validDestinationTiles.addAll(getAllTunnelsAndMine_notSelf(tileFrom, player));
    }

    //deal GREEN_ALBION rally (mech and char move to worker or token)
    if (player.GREEN_ALBION_mechAndCharacter_canMoveToWorkerOrFlagTokenTerritory_rally && (movable.isCharacter() || movable.isMech())) {
      validDestinationTiles.addAll((getAllWorkerAndTokenTiles_possiblySelf(player)));
    }

    // TODO player attributes that might also be important:
    // Teleportation and special spatial adjacencies:
//    player.BLACK_SAXONY_mountainsAndTunnelsAreAdjacent_underpass;                     // Treats controlled Mountains, Tunnels, and Mine as adjacent
//    player.PURPLE_TOGAWA_canMoveToAnyTrapTokenAndRearmDisarmedTrap_shinobi;          // Allows direct move to any tile containing your Trap token
//    player.RED_RUSVIET_controlledVillagesAndFactoryAreAdjacent_township;             // Treats controlled Villages and central Factory as adjacent
//    player.YELLOW_CRIMEA_moveToOrFrom_ownOrInactiveFactionHome_wayfare;             // Allows move directly to/from your home or inactive faction homes
    // River crossing rules based on destination tile terrain:
//    player.BLUE_NORDIC_workersCanCrossRivers_swim;                       // Allows workers to cross rivers onto any terrain except lakes
//    player.BLACK_SAXONY_canCrossRiverOntoForestOrMountain_riverwalk;     // Cross rivers onto Forest or Mountain tiles
//    player.BLUE_NORDIC_canCrossRiverOntoForestOrMountain_riverwalk;     // Cross rivers onto Forest or Mountain tiles
//    player.RED_RUSVIET_canCrossRiverOntoFarmOrVillage_riverwalk;         // Cross rivers onto Farm or Village tiles
//    player.WHITE_POLANIA_canCrossRiverOntoVillagesAndMountains_riverwalk;// Cross rivers onto Village or Mountain tiles
//    player.YELLOW_CRIMEA_canCrossRiverOntoFarmsAndTundra_riverwalk;      // Cross rivers onto Farm or Tundra tiles
//    player.PURPLE_TOGAWA_canCrossRiverOncePerMoveAction_toka;            // Limits river crossing to once per move action
    // Enables lake tiles as valid move destinations:
//    player.BLUE_NORDIC_canMoveToOrFromLakes_seaworthy;                      // Move onto/off lake tiles and retreat onto adjacent lakes
//    player.PURPLE_TOGAWA_canMoveToOrFromLakesAndPlayAdditionalCombatCardThere_suiton; // Move onto/off lake tiles
//    player.WHITE_POLANIA_canMoveOnLake_canMoveToAnyLake_submerge;            // Move onto/off lakes and move directly between any lake tiles
    // Increases unit movement range (expanding the reach of reachable tiles):     // TODO: if moving 2 tiles allowed, both should be completed at once, since attack on moving first tile would prevent from going second tile (additional info: first tile cannot be skipped from action)
//    player.BLACK_SAXONY_characterAndMechsGetPlus1Move_speed; // Grants +1 step distance to Character/Mechs
//    player.BLUE_NORDIC_characterAndMechsGetPlus1Move_speed;  // Grants +1 step distance to Character/Mechs
//    player.RED_RUSVIET_characterAndMechsGetPlus1Move_speed;  // Grants +1 step distance to Character/Mechs
//    player.WHITE_POLANIA_characterAndMechsGetPlus1Move_speed;// Grants +1 step distance to Character/Mechs
//    player.YELLOW_CRIMEA_characterAndMechsGetPlus1Move_speed; // Grants +1 step distance to Character/Mechs


    return validDestinationTiles;
  }

  private static Set<TileDTO> getAllWorkerAndTokenTiles_possiblySelf(PlayerDTO player) {
    Set<TileDTO> tilesWithWorkerOrToken = new HashSet<>();
    for (TokenDTO token : player.placed_tokens) tilesWithWorkerOrToken.add(token.getLocation());
    for (WorkerDTO worker : player.placed_workers) tilesWithWorkerOrToken.add(worker.getLocation());
    return tilesWithWorkerOrToken;
  }

  private static Set<TileDTO> getAllTunnelsAndMine_notSelf(TileDTO self, PlayerDTO player) {
    Set<TileDTO> result = new HashSet<>(tunnels); //separate list but same references to items
    TileDTO mineTile = player.buildingsBuilt_presentOnGrid.get(BuildingType.MINE).location;
    if (mineTile != null) result.add(mineTile);
    result.remove(self);
    return result;
  }

  private static boolean hasTileMine(TileDTO questionedTile, PlayerDTO player) {
    BuildingDTO playerMine = player.buildingsBuilt_presentOnGrid.get(BuildingType.MINE);
    if (playerMine == null) return false;
    return playerMine.getLocation() == questionedTile;
  }
}



