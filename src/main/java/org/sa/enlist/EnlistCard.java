package org.sa.enlist;

import org.sa.b_storage.reward.*;

import java.util.List;

public enum EnlistCard {

  //TODO: finish CONOR_AND_MAX_CLAN_ALBION enlist card
  CONOR_AND_MAX_CLAN_ALBION(
      List.of(new Reward_FlagTokens_Exalt()),
      List.of(new Reward_Attack(3), new Reward_AttackCards(0)),
      List.of(
          new Reward_RiverCrossingToOrFromTunnel_Burrow(),
          new Reward_MinusAttackForOpponent_Sword(),
          new Reward_PlusAttackBeforeDefence_Shield(),
          new Reward_RiverCrossingToOrFromTunnel_Burrow()), //TODO: finish
      List.of(new Reward_Attack(2), new Reward_Coins(2), new Reward_Hearts(2), new Reward_AttackCards(2))
  );

  public final List<Reward> initialReward; //top right corner
  public final List<Reward> initialBonusToApply;
  public final List<Reward> abilityPoolToUnlock; //right side
  public final List<Reward> bonusPoolToUnlock; //left side

  EnlistCard(
      List<Reward> initialReward,
      List<Reward> initialBonusToApply,
      List<Reward> abilityPoolToUnlock,
      List<Reward> bonusPoolToUnlock
  ) {
      this.initialReward = initialReward;
      this.initialBonusToApply = initialBonusToApply;
      this.abilityPoolToUnlock = abilityPoolToUnlock;
      this.bonusPoolToUnlock = bonusPoolToUnlock;
  }
}

