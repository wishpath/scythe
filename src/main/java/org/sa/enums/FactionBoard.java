package org.sa.enums;

import org.sa.DTO.ActionSpaceDTO;
import org.sa.DTO.TileDTO;
import org.sa.reward.cost_upgradable.UpgradableCost_Food;
import org.sa.reward.cost_upgradable.UpgradableCost_Metal;
import org.sa.reward.cost_upgradable.UpgradableCost_Oil;
import org.sa.reward.cost_upgradable.UpgradableCost_Wood;

import static org.sa.b_storage.Grid.grid;

public enum FactionBoard {

  //TODO: finish up entering faction details
  //TODO: finish up entering initialActionSpaces[]
  RED("Rusviet Union", -1, -1, -1, 2,  grid[3][9], new ActionSpaceDTO[4]),
  BLACK("Saxony Empire", -1, -1, -1, 2, grid[7][0], new ActionSpaceDTO[4]),
  YELLOW("Crimean Khanate",  -1, -1, -1, 2, grid[8][2], new ActionSpaceDTO[4]),
  WHITE("Republic of Polania", -1, -1, -1, 2, grid[3][2], new ActionSpaceDTO[4]),
  BLUE("Nordic Kingdoms",  -1, -1, -1, 2, grid[0][8], new ActionSpaceDTO[4]),

  GREEN(
      "Clan Albion",
      4,
      7,
      2,
      2,
      grid[0][5],
      new ActionSpaceDTO[] {  //TODO: finish
        new ActionSpaceDTO(ActionBottom.UPGRADE, new UpgradableCost_Oil(-2,-2), 1),
        new ActionSpaceDTO(ActionBottom.DEPLOY, new UpgradableCost_Metal(-4,-2), 1),
        new ActionSpaceDTO(ActionBottom.BUILD, new UpgradableCost_Wood(-4,-2), 1),
        new ActionSpaceDTO(ActionBottom.ENLIST, new UpgradableCost_Food(-3,-1), 1),
      }
  ),

  PURPLE("Togawa Shogunate", -1, -1, -1, 2, grid[7][7], new ActionSpaceDTO[4]);


  public final String name;
  public final int initialHearts;
  public final int initialCoins;
  public final int initialMissionCards;
  public final int initialWorkersCount;
  public final TileDTO home;
  public ActionSpaceDTO[] initialActionSpaces;


  FactionBoard(
      String name,
      int initialHearts,
      int initialCoins,
      int initialMissionCards,
      int initialWorkers,
      TileDTO home,
      ActionSpaceDTO[] initialActionSpaces) {

    this.name = name;
    this.initialHearts = initialHearts;
    this.initialCoins = initialCoins;
    this.initialMissionCards = initialMissionCards;
    this.initialWorkersCount = initialWorkers;
    this.home = home;
    this.initialActionSpaces = initialActionSpaces;
  }
}

