package org.sa.enums;

import org.sa.DTO.ActionSpaceDTO;
import org.sa.reward.cost_upgradable.UpgradableCost_Food;
import org.sa.reward.cost_upgradable.UpgradableCost_Metal;
import org.sa.reward.cost_upgradable.UpgradableCost_Oil;
import org.sa.reward.cost_upgradable.UpgradableCost_Wood;

public enum PlayerMat { // does not belong to faction

  //TODO: finish up entering faction details
  //TODO: finish up entering initialActionSpaces[]
  RED( -1, -1, -1, 2,  new ActionSpaceDTO[4]), //TODO: finish
  BLACK( -1, -1, -1, 2, new ActionSpaceDTO[4]), //TODO: finish
  YELLOW( -1, -1, -1, 2, new ActionSpaceDTO[4]), //TODO: finish
  WHITE( -1, -1, -1, 2, new ActionSpaceDTO[4]), //TODO: finish
  BLUE( -1, -1, -1, 2, new ActionSpaceDTO[4]), //TODO: finish

  AGRICULTURAL(
      4,
      7,
      2,
      2,
      new ActionSpaceDTO[] {  //TODO: finish: top action,
        new ActionSpaceDTO(ActionBottom.UPGRADE, new UpgradableCost_Oil(-2,-2), 1), //TODO: finish
        new ActionSpaceDTO(ActionBottom.DEPLOY, new UpgradableCost_Metal(-4,-2), 1), //TODO: finish
        new ActionSpaceDTO(ActionBottom.BUILD, new UpgradableCost_Wood(-4,-2), 1), //TODO: finish
        new ActionSpaceDTO(ActionBottom.ENLIST, new UpgradableCost_Food(-3,-1), 1), //TODO: finish
      }
  ),

  PURPLE(-1, -1, -1, 2, new ActionSpaceDTO[4]);



  public final int initialHearts;
  public final int initialCoins;
  public final int initialMissionCards;
  public final int initialWorkersCount;
  public ActionSpaceDTO[] initialActionSpaces;


  PlayerMat(
      int initialHearts,
      int initialCoins,
      int initialMissionCards,
      int initialWorkers,
      ActionSpaceDTO[] initialActionSpaces) {

    this.initialHearts = initialHearts;
    this.initialCoins = initialCoins;
    this.initialMissionCards = initialMissionCards;
    this.initialWorkersCount = initialWorkers;
    this.initialActionSpaces = initialActionSpaces;
  }
}

