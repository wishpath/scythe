package org.sa.faction_mat;

import org.sa.faction_mat.Left_EnlistOneTimeReward.*;
import org.sa.faction_mat.RightBottom_MechDeployAbility.*;
import org.sa.faction_mat.RightMid_FactionInitialBonus.RightMid_FactionInitialBonus;
import org.sa.faction_mat.RightMid_FactionInitialBonus.RightMid_FactionInitialBonus_Attack;
import org.sa.faction_mat.RightMid_FactionInitialBonus.RightMid_FactionInitialBonus_AttackCards;
import org.sa.faction_mat.RightTop_FactionAbility.RightTop_FactionAbility;
import org.sa.faction_mat.RightTop_FactionAbility.RightTop_FactionAbility_FlagTokens_Exalt_GREEN;
import org.sa.grid.TileDTO;

import java.util.List;

import static org.sa.grid.Grid.grid;

public enum FactionMat {
  /*
   * SCYTHE FACTIONS (Base Game + Expansions)
   *
   * Base Game Factions:
   *   - Rusviet Union       – Red
   *   - Crimean Khanate     – Yellow
   *   - Polania Republic    – White
   *   - Saxony Empire       – Black
   *   - Nordic Kingdom      – Blue
   *
   * Expansion Factions:
   *   - Clan Albion          – Green
   *   - Togawa Shogunate     – Purple
   *   - Vesna‑Tesla          – Teal
   *   - Fenris Republic      – Orange
   */

  GREEN(
      "Clan Albion",

      //initialReward_factionAbility_ongoing; //top right corner
      List.of(new RightTop_FactionAbility_FlagTokens_Exalt_GREEN()),

      //initialBonusToApply_oneTime //right side (below faction ability)
      List.of(
          new RightMid_FactionInitialBonus_Attack(3),
          new RightMid_FactionInitialBonus_AttackCards(0)),

      //unlockableByMechDeploy_ongoingAbilitiesPool; //right-bottom corner
      List.of(
          new RightBottom_MechDeployAbility_RiverCrossingToOrFromTunnel_Burrow(),
          new RightBottom_MechDeployAbility_MinusAttackForOpponent_Sword(),
          new RightBottom_MechDeployAbility_PlusAttackBeforeDefence_Shield(),
          new RightBottom_MechDeployAbility_CanMoveToWorkerOrFlagTokenTerritory_Rally()),

      //unlockableByEnlistAction_oneTimeRewardPool; //left-bottom corner
      List.of(
          new Left_EnlistOneTimeReward_Attack(2),
          new Left_EnlistOneTimeReward_Coins(2),
          new Left_EnlistOneTimeReward_Hearts(2),
          new Left_EnlistOneTimeReward_AttackCards(2)),

      //home
      grid[0][5]
  ),
  RED("Rusviet Union", List.of(), List.of(), List.of(), List.of(), grid[0][0]), //TODO: finish
  YELLOW("Crimean Khanate", List.of(), List.of(), List.of(), List.of(), grid[0][0]), //TODO: finish
  WHITE("Polania Republic", List.of(), List.of(), List.of(), List.of(), grid[0][0]), //TODO: finish
  BLACK("Saxony Empire", List.of(), List.of(), List.of(), List.of(), grid[0][0]), //TODO: finish
  BLUE("Nordic Kingdom", List.of(), List.of(), List.of(), List.of(), grid[0][0]), //TODO: finish
  PURPLE("Togawa Shogunate", List.of(), List.of(), List.of(), List.of(), grid[0][0]), //TODO: finish
  TEAL("Vesna-Tesla", List.of(), List.of(), List.of(), List.of(), grid[0][0]), //TODO: finish
  ORANGE("Fenris Republic", List.of(), List.of(), List.of(), List.of(), grid[0][0]); //TODO: finish

  public final String name;
  //right
  public final List<RightTop_FactionAbility> initialReward_factionAbility_ongoing; //top right corner
  public final List<RightMid_FactionInitialBonus> initialBonusToApply_oneTime; //right side (below the faction ability)
  public final List<RightBottom_MechDeployAbility> unlockableByMechDeploy_ongoingAbilitiesPool; //right-bottom corner
  //left
  public final List<Left_EnlistOneTimeReward> unlockableByEnlistAction_oneTimeRewardPool; //left-bottom corner //TODO also implement the related ongoing rewards related to player mat and neighbor actions
  public final TileDTO homeTile;
  public final int initialWorkersCount = 2;

  FactionMat(
      String name,
      List<RightTop_FactionAbility> initialReward_factionAbility_ongoing, //top right corner
      List<RightMid_FactionInitialBonus> initialBonusToApply_oneTime, //right side (below the faction ability)
      List<RightBottom_MechDeployAbility> unlockableByMechDeploy_abilitiesPool, //right-bottom corner
      List<Left_EnlistOneTimeReward> unlockableByEnlistAction_oneTimeRewardPool, //left-bottom corner
      TileDTO homeTile
  ) {
    this.name = name;
    this.initialReward_factionAbility_ongoing = initialReward_factionAbility_ongoing;
    this.initialBonusToApply_oneTime = initialBonusToApply_oneTime;
    this.unlockableByMechDeploy_ongoingAbilitiesPool = unlockableByMechDeploy_abilitiesPool;
    this.unlockableByEnlistAction_oneTimeRewardPool = unlockableByEnlistAction_oneTimeRewardPool;
    this.homeTile = homeTile;
  }
}

