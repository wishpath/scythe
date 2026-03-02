package org.sa.enums;

import org.sa.DTO.TileDTO;
import org.sa.reward.*;
import org.sa.reward.ability.Ability_CanMoveToControlledTerritory_Rally;
import org.sa.reward.ability.Ability_MinusAttackForOpponent_Sword;
import org.sa.reward.ability.Ability_PlusAttackBeforeDefence_Shield;
import org.sa.reward.ability.Ability_RiverCrossingToOrFromTunnel_Burrow;

import java.util.List;

import static org.sa.b_storage.Grid.grid;

public enum FactionMat_EnlistCard {
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
      List.of(new Reward_FlagTokens_Exalt()),
      List.of(new Reward_Attack(3), new Reward_AttackCards(0)),
      List.of(
          new Ability_RiverCrossingToOrFromTunnel_Burrow(),
          new Ability_MinusAttackForOpponent_Sword(),
          new Ability_PlusAttackBeforeDefence_Shield(),
          new Ability_CanMoveToControlledTerritory_Rally()),
      List.of(
          new Reward_Attack(2),
          new Reward_Coins(2),
          new Reward_Hearts(2),
          new Reward_AttackCards(2)),
      grid[0][5]
  );

  public final String name;
  public final List<Reward> initialReward; //top right corner
  public final List<Reward> initialBonusToApply;
  public final List<Reward> abilityPoolToUnlock; //right side
  public final List<Reward> bonusPoolToUnlock; //left side
  public final TileDTO home;

  FactionMat_EnlistCard(
      String name,
      List<Reward> initialReward,
      List<Reward> initialBonusToApply,
      List<Reward> abilityPoolToUnlock,
      List<Reward> bonusPoolToUnlock,
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

