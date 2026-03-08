package org.sa.enums;

import org.sa.DTO.ActionSpaceDTO;
import org.sa.reward.Reward;
import org.sa.reward.cost_upgradable.*;

public enum PlayerMat {
  AGRICULTURAL(
      4,
      7,
      2,
      2,
      new ActionSpaceDTO[] {  //TODO: finish: top action,
        new ActionSpaceDTO(
            ActionTop.MOVE_GAIN,
            new UpgradableCost_Coins(0, 0),
            new Reward[]{},
            ActionBottom.UPGRADE,
            new UpgradableCost_Oil(-2,-2),
            1), //TODO: finish
        new ActionSpaceDTO(
            ActionTop.TRADE,
            new UpgradableCost_Coins(1, 1),
            new Reward[]{},
            ActionBottom.DEPLOY,
            new UpgradableCost_Metal(-4,-2),
            1), //TODO: finish
        new ActionSpaceDTO(
            ActionTop.PRODUCE,
            new UpgradableCost_Produce(),
            new Reward[]{},
            ActionBottom.BUILD,
            new UpgradableCost_Wood(-4,-2),
            1), //TODO: finish
        new ActionSpaceDTO(
            ActionTop.BOLSTER,
            new UpgradableCost_Coins(1, 1),
            new Reward[]{},
            ActionBottom.ENLIST,
            new UpgradableCost_Food(-3,-1),
            1), //TODO: finish
      }
  ),

  //TODO: finish up entering initialActionSpaces[]
  ENGINEERING(-1, -1, -1, 2, new ActionSpaceDTO[4]),
  INDUSTRIAL( -1, -1, -1, 2,  new ActionSpaceDTO[4]), //TODO: finish
  INNOVATIVE( -1, -1, -1, 2, new ActionSpaceDTO[4]), //TODO: finish
  MECHANICAL( -1, -1, -1, 2, new ActionSpaceDTO[4]), //TODO: finish
  MILITANT( -1, -1, -1, 2, new ActionSpaceDTO[4]), //TODO: finish
  PATRIOTIC( -1, -1, -1, 2, new ActionSpaceDTO[4]); //TODO: finish



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

