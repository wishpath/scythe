package org.sa.b_storage;

import org.junit.jupiter.api.Test;
import org.sa.DTO.TileDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}