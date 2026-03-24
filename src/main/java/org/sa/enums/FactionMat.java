package org.sa.enums;

import org.sa.DTO.TileDTO;
import org.sa.reward.*;
import org.sa.reward.get_ability.GetAbility_CanMoveToControlledTerritory_Rally;
import org.sa.reward.get_ability.GetAbility_MinusAttackForOpponent_Sword;
import org.sa.reward.get_ability.GetAbility_PlusAttackBeforeDefence_Shield;
import org.sa.reward.get_ability.GetAbility_RiverCrossingToOrFromTunnel_Burrow;
import org.sa.reward.reward_basic.*;

import java.util.List;

import static org.sa.b_storage.Grid.grid;

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
      List.of(new RewardBasic_FlagTokens_Exalt()),
      List.of(new RewardBasic_Attack(3), new RewardBasic_AttackCards(0)),
      List.of(
          new GetAbility_RiverCrossingToOrFromTunnel_Burrow(),
          new GetAbility_MinusAttackForOpponent_Sword(),
          new GetAbility_PlusAttackBeforeDefence_Shield(),
          new GetAbility_CanMoveToControlledTerritory_Rally()),
      List.of(
          new RewardBasic_Attack(2),
          new RewardBasic_Coins(2),
          new RewardBasic_Hearts(2),
          new RewardBasic_AttackCards(2)),
      grid[0][5]
  );

  public final String name;
  public final List<StateChange> initialReward; //top right corner
  public final List<StateChange> initialBonusToApply;
  public final List<StateChange> abilityPoolToUnlock; //right side
  public final List<StateChange> bonusPoolToUnlock; //left side
  public final TileDTO home;
  public final int initialWorkersCount = 2;

  FactionMat(
      String name,
      List<StateChange> initialReward,
      List<StateChange> initialBonusToApply,
      List<StateChange> abilityPoolToUnlock,
      List<StateChange> bonusPoolToUnlock,
      TileDTO home
  ) {
      this.name = name;
      this.initialReward = initialReward;
      this.initialBonusToApply = initialBonusToApply;
      this.abilityPoolToUnlock = abilityPoolToUnlock;
      this.bonusPoolToUnlock = bonusPoolToUnlock;
      this.home = home;
  }
}

