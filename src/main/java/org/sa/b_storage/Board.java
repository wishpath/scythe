package org.sa.b_storage;

import org.sa.DTO.TileDTO;
import org.sa.enums.Direction;
import org.sa.enums.TileType;

import java.util.HashSet;
import java.util.Set;

public class Board {
  public static TileDTO[][] grid = new TileDTO[9][10];
  public static final TileDTO CENTER_FACTORY = new TileDTO(TileType.CENTER, 4, 5);

  static {
    //TODO: test rivers,
    //    - no tiles match for in exact grid coordinates,
    //    - has at least 2 neighbours
    // neighbour should have another half of the same river (or is null)
    // rivers should not neighbor lakes
    grid[0][5] = new TileDTO(TileType.HOME, 0, 5);
    grid[0][8] = new TileDTO(TileType.METAL, 0, 8);

    grid[1][4] = new TileDTO(TileType.METAL, 1, 4);
    grid[1][5] = new TileDTO(TileType.FOOD, 1, 5);
    grid[1][6] = new TileDTO(TileType.WORKER, 1, 6)
        .setRivers(Direction.EAST, Direction.SOUTH_EAST);
    grid[1][7] = new TileDTO(TileType.WOOD, 1, 7)
        .setRivers(Direction.SOUTH_WEST, Direction.WEST);
    grid[1][8] = new TileDTO(TileType.OIL, 1, 8)
        .setRivers(Direction.EAST, Direction.SOUTH_EAST);
    grid[1][9] = new TileDTO(TileType.WORKER, 1, 9)
        .setRivers(Direction.WEST);

    grid[2][3] = new TileDTO(TileType.WATER, 2, 3);
    grid[2][4] = new TileDTO(TileType.OIL, 2, 4)
        .setRivers(Direction.SOUTH_WEST);
    grid[2][5] = new TileDTO(TileType.WATER, 2, 5);
    grid[2][6] = new TileDTO(TileType.OIL, 2, 6)
        .markAsTunnel()
        .setRivers(Direction.NORTH_WEST, Direction.NORTH_EAST, Direction.EAST);
    grid[2][7] = new TileDTO(TileType.METAL, 2, 7)
        .setRivers(Direction.WEST, Direction.EAST, Direction.SOUTH_EAST);
    grid[2][8] = new TileDTO(TileType.FOOD, 2, 8)
        .setRivers(Direction.WEST, Direction.NORTH_WEST, Direction.SOUTH_EAST);
    grid[2][9] = new TileDTO(TileType.FOOD, 2, 9)
        .setRivers(Direction.SOUTH_EAST, Direction.SOUTH_WEST);

    grid[3][2] = new TileDTO(TileType.HOME, 3, 2);
    grid[3][3] = new TileDTO(TileType.WOOD, 3, 3)
        .setRivers(Direction.NORTH_EAST, Direction.EAST);
    grid[3][4] = new TileDTO(TileType.METAL, 3, 4)
        .markAsTunnel()
        .setRivers(Direction.WEST, Direction.SOUTH_WEST);
    grid[3][5] = new TileDTO(TileType.WOOD, 3, 5);
    grid[3][6] = new TileDTO(TileType.WATER, 3, 6);
    grid[3][7] = new TileDTO(TileType.WOOD, 3, 7)
        .markAsTunnel()
        .setRivers(Direction.NORTH_WEST, Direction.EAST, Direction.SOUTH_EAST);
    grid[3][8] = new TileDTO(TileType.WORKER, 3, 8)
        .setRivers(Direction.WEST, Direction.NORTH_WEST, Direction.NORTH_EAST);
    grid[3][9] = new TileDTO(TileType.HOME, 3, 9)
        .setRivers(Direction.NORTH_WEST);

    grid[4][2] = new TileDTO(TileType.FOOD, 4, 2)
        .setRivers(Direction.SOUTH_WEST, Direction.SOUTH_EAST);
    grid[4][3] = new TileDTO(TileType.WORKER, 4, 3)
        .setRivers(Direction.SOUTH_WEST, Direction.SOUTH_EAST, Direction.NORTH_EAST);
    grid[4][4] = new TileDTO(TileType.WATER, 4, 4);
    grid[4][5] = CENTER_FACTORY;
    grid[4][6] = new TileDTO(TileType.METAL, 4, 6)
        .setRivers(Direction.EAST);
    grid[4][7] = new TileDTO(TileType.OIL, 4, 7)
        .setRivers(Direction.SOUTH_WEST, Direction.WEST, Direction.NORTH_WEST);
    grid[4][8] = new TileDTO(TileType.METAL, 4, 8);

    grid[5][1] = new TileDTO(TileType.WOOD,  5, 1)
        .setRivers(Direction.NORTH_WEST, Direction.NORTH_EAST, Direction.SOUTH_EAST, Direction.SOUTH_WEST);
    grid[5][2] = new TileDTO(TileType.WOOD,  5, 2)
        .setRivers(Direction.NORTH_WEST, Direction.NORTH_EAST, Direction.SOUTH_EAST, Direction.SOUTH_WEST);
    grid[5][3] = new TileDTO(TileType.FOOD,  5, 3)
        .markAsTunnel()
        .setRivers(Direction.NORTH_WEST, Direction.SOUTH_WEST);
    grid[5][4] = new TileDTO(TileType.OIL,  5, 4);
    grid[5][5] = new TileDTO(TileType.WATER,  5, 5);
    grid[5][6] = new TileDTO(TileType.WORKER,  5, 6)
        .markAsTunnel()
        .setRivers(Direction.NORTH_EAST);
    grid[5][7] = new TileDTO(TileType.WATER,  5, 7);

    grid[6][1] = new TileDTO(TileType.METAL,  6, 1)
        .setRivers(Direction.NORTH_WEST, Direction.NORTH_EAST);
    grid[6][2] = new TileDTO(TileType.WORKER,  6, 2)
        .setRivers(Direction.NORTH_WEST, Direction.NORTH_EAST, Direction.EAST);
    grid[6][3] = new TileDTO(TileType.WORKER,  6, 3)
        .setRivers(Direction.WEST, Direction.SOUTH_EAST);
    grid[6][4] = new TileDTO(TileType.OIL,  6, 4)
        .markAsTunnel()
        .setRivers(Direction.SOUTH_EAST, Direction.SOUTH_WEST);
    grid[6][5] = new TileDTO(TileType.WOOD,  6, 5)
        .setRivers(Direction.SOUTH_WEST);
    grid[6][6] = new TileDTO(TileType.METAL,  6, 6);
    grid[6][7] = new TileDTO(TileType.OIL,  6, 7);

    grid[7][0] = new TileDTO(TileType.HOME,  7, 0);
    grid[7][1] = new TileDTO(TileType.OIL,  7, 1);
    grid[7][2] = new TileDTO(TileType.WATER,  7, 2);
    grid[7][3] = new TileDTO(TileType.FOOD,  7, 3)
        .setRivers(Direction.NORTH_WEST, Direction.NORTH_EAST);
    grid[7][4] = new TileDTO(TileType.METAL,  7, 4)
        .setRivers(Direction.NORTH_WEST, Direction.NORTH_EAST, Direction.EAST);
    grid[7][5] = new TileDTO(TileType.WORKER,  7, 5)
        .setRivers(Direction.WEST);
    grid[7][6] = new TileDTO(TileType.FOOD,  7, 6);
    grid[7][6] = new TileDTO(TileType.FOOD,  7, 6);
    grid[7][7] = new TileDTO(TileType.HOME,  7, 7);

    grid[8][2] = new TileDTO(TileType.HOME,  8, 2);
    grid[8][3] = new TileDTO(TileType.WORKER,  8, 3);
  }

  public static boolean isItemAdjacent(TileDTO tile, TileDTO itemLocation) {
    for (Direction direction : Direction.values())
      if (isAdjacentToDirection(tile, direction, itemLocation))
        return true;
    return false;
  }

  public static boolean isAdjacentToDirection(TileDTO tile, Direction direction, TileDTO itemLocation) {
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
    for (Direction direction : Direction.values()) {
      int row = tile.row + direction.deltaRow;
      if (row < 0 || row >= grid.length) continue;

      int column = tile.column + direction.deltaColumn;
      if (column < 0 || column >= grid[0].length) continue;

      TileDTO neighbor = grid[row][column];
      if (neighbor != null && !neighbor.equals(tile)) neighbors.add(neighbor);
    }
    return neighbors;
  }
}



