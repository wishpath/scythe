package org.sa.enums;

import org.sa.DTO.TileDTO;

import static org.sa.b_storage.Board.grid;

public enum Faction {

  //TODO: finish up entering faction details
  RED("Rusviet Union", -1, -1, -1, 2,  grid[3][9]),
  BLACK("Saxony Empire", -1, -1, -1, 2, grid[7][0]),
  YELLOW("Crimean Khanate",  -1, -1, -1, 2, grid[8][2]),
  WHITE("Republic of Polania", -1, -1, -1, 2, grid[3][2]),
  BLUE("Nordic Kingdoms",  -1, -1, -1, 2, grid[0][8]),
  GREEN("Clan Albion", 4, 7, 2, 2, grid[0][5]),
  PURPLE("Togawa Shogunate", -1, -1, -1, 2, grid[7][7]);


  public final String name;
  public final int initialHearts;
  public final int initialCoins;
  public final int initialMissionCards;
  public final int initialWorkersCount;
  public final TileDTO home;

  Faction(String name, int initialHearts, int initialCoins, int initialMissionCards, int initialWorkers, TileDTO home) {
    this.name = name;
    this.initialHearts = initialHearts;
    this.initialCoins = initialCoins;
    this.initialMissionCards = initialMissionCards;
    this.initialWorkersCount = initialWorkers;
    this.home = home;
  }
}

