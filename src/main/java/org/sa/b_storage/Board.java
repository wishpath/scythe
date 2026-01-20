package org.sa.b_storage;

import org.sa.DTO.TileDTO;
import org.sa.enums.TileType;

public class Board {
  public TileDTO[][] grid = new TileDTO[8][9];

  public Board() {
    grid[0][3] = new TileDTO(TileType.METAL, 0, 3);
    grid[0][4] = new TileDTO(TileType.FOOD, 0, 4);
    grid[0][5] = new TileDTO(TileType.WORKER, 0, 5);
    grid[0][6] = new TileDTO(TileType.WOOD, 0, 6);
    grid[0][7] = new TileDTO(TileType.OIL, 0, 7);
    grid[0][8] = new TileDTO(TileType.WORKER, 0, 8);

    grid[1][2] = new TileDTO(TileType.WATER, 1, 2);
    grid[1][3] = new TileDTO(TileType.OIL, 1, 3);
    grid[1][4] = new TileDTO(TileType.WATER, 1, 4);
    grid[1][5] = new TileDTO(TileType.OIL, 1, 5).markAsTunnel();
    grid[1][6] = new TileDTO(TileType.METAL, 1, 6);
    grid[1][7] = new TileDTO(TileType.FOOD, 1, 7);
    grid[1][8] = new TileDTO(TileType.FOOD, 1, 8);

    grid[2][2] = new TileDTO(TileType.WOOD, 2, 2);
    grid[2][3] = new TileDTO(TileType.METAL, 2, 3).markAsTunnel();
    grid[2][4] = new TileDTO(TileType.WOOD, 2, 4);
    grid[2][5] = new TileDTO(TileType.WATER, 2, 5);
    grid[2][6] = new TileDTO(TileType.WOOD, 2, 6).markAsTunnel();
    grid[2][7] = new TileDTO(TileType.WORKER, 2, 7);

    grid[3][1] = new TileDTO(TileType.FOOD, 3, 1);
    grid[3][2] = new TileDTO(TileType.WORKER, 3, 2);
    grid[3][3] = new TileDTO(TileType.WATER, 3, 3);
    grid[3][4] = new TileDTO(TileType.CENTER, 3, 4);
    grid[3][5] = new TileDTO(TileType.METAL, 3, 5);
    grid[3][6] = new TileDTO(TileType.OIL, 3, 6);
    grid[3][7] = new TileDTO(TileType.METAL, 3, 7);

    grid[4][0] = new TileDTO(TileType.NULL,  4, 0);
    grid[4][1] = new TileDTO(TileType.NULL,  4, 1);
    grid[4][2] = new TileDTO(TileType.NULL,  4, 2);
    grid[4][3] = new TileDTO(TileType.NULL,  4, 3);
    grid[4][4] = new TileDTO(TileType.NULL,  4, 4);
    grid[4][5] = new TileDTO(TileType.NULL,  4, 5);
    grid[4][6] = new TileDTO(TileType.NULL,  4, 6);

    grid[5][0] = new TileDTO(TileType.NULL,  5, 0);
    grid[5][1] = new TileDTO(TileType.NULL,  5, 1);
    grid[5][2] = new TileDTO(TileType.NULL,  5, 2);
    grid[5][3] = new TileDTO(TileType.NULL,  5, 3);
    grid[5][4] = new TileDTO(TileType.NULL,  5, 4);
    grid[5][5] = new TileDTO(TileType.NULL,  5, 5);
    grid[5][6] = new TileDTO(TileType.NULL,  5, 6);

    grid[6][0] = new TileDTO(TileType.NULL,  6, 0);
    grid[6][1] = new TileDTO(TileType.NULL,  6, 1);
    grid[6][2] = new TileDTO(TileType.NULL,  6, 2);
    grid[6][3] = new TileDTO(TileType.NULL,  6, 3);
    grid[6][4] = new TileDTO(TileType.NULL,  6, 4);
    grid[6][5] = new TileDTO(TileType.NULL,  6, 5);
  }
}



