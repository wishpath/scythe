package org.sa.b_storage;

import org.junit.jupiter.api.Test;
import org.sa.DTO.TileDTO;
import org.sa.enums.Direction;
import org.sa.enums.TileType;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

  @Test
  void gridIndexMatchesDtoIndex() {
    for (int row = 0; row < Board.grid.length; row++)
      for (int column = 0; column < Board.grid[0].length; column++) {
        TileDTO tile = Board.grid[row][column];
        if (tile == null) continue;
        assertEquals(row, tile.row);
        assertEquals(column, tile.column);
      }
  }

  @Test
  void eachNonNullTileHasAtLeastTwoNeighbors() {
    for (int row = 0; row < Board.grid.length; row++)
      for (int column = 0; column < Board.grid[0].length; column++) {
        TileDTO tile = Board.grid[row][column];
        if (tile == null) continue;

        Set<TileDTO> neighbors = Board.getNonNullNeighborsNotSelf(tile);
        assertTrue(neighbors.size() >= 2,
            "Tile at [" + row + "," + column + "] has only " + neighbors.size() + " neighbors");
      }
  }


  @Test
  void riversDoNotBorderLakes() {
    for (int row = 0; row < Board.grid.length; row++)
      for (int column = 0; column < Board.grid[0].length; column++) {
        TileDTO tile = Board.grid[row][column];
        if (tile == null || tile.rivers.isEmpty()) continue;

        for (Direction riverDirection : tile.rivers) {
          TileDTO neighbor = Board.getNeighbor(tile, riverDirection);
          if (neighbor == null) continue;

          assertNotEquals(
              TileType.LAKE,
              neighbor.tileType,
              "Tile at [" + row + "," + column + "] borders lake in direction " + riverDirection
          );
        }
      }
  }

  @Test
  void lakesShouldNotHaveRivers() {
    for (int row = 0; row < Board.grid.length; row++)
      for (int column = 0; column < Board.grid[0].length; column++) {
        TileDTO tile = Board.grid[row][column];
        if (tile == null || tile.tileType != TileType.LAKE) continue;

        assertEquals(
            0,
            tile.rivers.size(),
            "Tile at [" + row + "," + column + "] is lake but has rivers"
        );
      }
  }

  @Test
  void neighborShouldHaveAnotherHalfOfTheSameRiver() {
    for (int row = 0; row < Board.grid.length; row++)
      for (int column = 0; column < Board.grid[0].length; column++) {
        TileDTO tile = Board.grid[row][column];
        if (tile == null || tile.tileType == TileType.LAKE) continue;
        for (Direction riverDirection : tile.rivers) {
          TileDTO neighbor = Board.getNeighbor(tile, riverDirection);
          if (neighbor == null) continue;
          Direction neededRiver = riverDirection.opposite();
          assertTrue(
              neighbor.rivers.contains(neededRiver),
              "Tile [" + row + "," + column + "] river " + riverDirection +
                  " not matched by neighbor [" + neighbor.row + "," + neighbor.column + "]"
          );
        }
      }
  }


}