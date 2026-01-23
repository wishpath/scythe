package org.sa.enums;

import org.sa.DTO.TileDTO;

import java.util.List;

import static org.sa.b_storage.Board.grid;

public enum Faction {

  RED("Rusviet Union", -1, -1, -1, 2,  List.of(/* tiles */)),
  BLACK("Saxony Empire", -1, -1, -1, 2, List.of(/* tiles */)),
  YELLOW("Crimean Khanate",  -1, -1, -1, 2, List.of(/* tiles */)),
  WHITE("Republic of Polania", -1, -1, -1, 2, List.of(/* tiles */)),
  BLUE("Nordic Kingdoms",  -1, -1, -1, 2, List.of(/* tiles */)),
  GREEN("Clan Albion", 4, 7, 2, 2, List.of(grid[0][3], grid[0][4])),
  PURPLE("Togawa Shogunate", -1, -1, -1, 2, List.of(/* tiles */));


  public final String name;
  public final int initialHearts;
  public final int initialCoins;
  public final int initialMissionCards;
  public final int initialWorkersCount;

  public final List<TileDTO> nextToHomeTiles;

  Faction(String name, int initialHearts, int initialCoins, int initialMissionCards, int initialWorkers, List<TileDTO> homeTiles) {
    this.name = name;
    this.initialHearts = initialHearts;
    this.initialCoins = initialCoins;
    this.initialMissionCards = initialMissionCards;
    this.nextToHomeTiles = List.copyOf(homeTiles);
  }
}

