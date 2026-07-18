package org.sa.enums;

import org.sa.grid.TileDTO;
import org.sa.state_change_bonus_reward_ability.*;
import org.sa.state_change_bonus_reward_ability.get_ability.MechDeployAbility_CanMoveToWorkerOrFlagTokenTerritory_Rally;
import org.sa.state_change_bonus_reward_ability.get_ability.MechDeployAbility_MinusAttackForOpponent_Sword;
import org.sa.state_change_bonus_reward_ability.get_ability.MechDeployAbility_PlusAttackBeforeDefence_Shield;
import org.sa.state_change_bonus_reward_ability.get_ability.MechDeployAbility_RiverCrossingToOrFromTunnel_Burrow;
import org.sa.state_change_bonus_reward_ability.reward_basic.*;

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
      List.of(new RewardBasic_FromFactionMat_FlagTokens_Exalt()),

      //initialBonusToApply_oneTime //right side (below faction ability)
      List.of(
          new ElistActionOneTimeReward_FromFactionMat_Attack(3),
          new ElistActionOneTimeReward_FromFactionMat_AttackCards(0)),

      //unlockableByMechDeploy_ongoingAbilitiesPool; //right-bottom corner
      List.of(
          new MechDeployAbility_RiverCrossingToOrFromTunnel_Burrow(),
          new MechDeployAbility_MinusAttackForOpponent_Sword(),
          new MechDeployAbility_PlusAttackBeforeDefence_Shield(),
          new MechDeployAbility_CanMoveToWorkerOrFlagTokenTerritory_Rally()),

      //unlockableByEnlistAction_oneTimeRewardPool; //left-bottom corner
      List.of(
          new ElistActionOneTimeReward_FromFactionMat_Attack(2),
          new ElistActionOneTimeReward_FromFactionMat_Coins(2),
          new ElistActionOneTimeReward_FromFactionMat_Hearts(2),
          new ElistActionOneTimeReward_FromFactionMat_AttackCards(2)),

      //home
      grid[0][5]
  );

  public final String name;
  public final List<StateChange> initialReward_factionAbility_ongoing; //top right corner
  public final List<StateChange> initialBonusToApply_oneTime; //right side (below the faction ability)
  public final List<StateChange> unlockableByMechDeploy_ongoingAbilitiesPool; //right-bottom corner
  public final List<StateChange> unlockableByEnlistAction_oneTimeRewardPool; //left-bottom corner //TODO also implement the related ongoing rewards related to player mat and neighbor actions
  public final TileDTO homeTile;
  public final int initialWorkersCount = 2;

  FactionMat(
      String name,
      List<StateChange> initialReward_factionAbility_ongoing, //top right corner
      List<StateChange> initialBonusToApply_oneTime, //right side (below the faction ability)
      List<StateChange> unlockableByMechDeploy_abilitiesPool, //right-bottom corner
      List<StateChange> unlockableByEnlistAction_oneTimeRewardPool, //left-bottom corner
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

