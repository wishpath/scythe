package org.sa.enlist;

import org.sa.b_storage.reward.*;

import java.util.List;

public enum EnlistCard {

  //TODO: finish CONOR_AND_MAX_CLAN_ALBION enlist card
  CONOR_AND_MAX_CLAN_ALBION(
      List.of(new Reward_FlagTokens()),
      List.of(new Reward_Attack(3), new Reward_AttackCards(0)),
      List.of(new AbilityExample(), new AbilityExample(), new AbilityExample(), new AbilityExample()),
      List.of(new Reward_Attack(2), new Reward_Coins(2), new Reward_Hearts(2), new Reward_AttackCards(2))
  );

  public final List<Reward> initialReward;
  public final List<Reward> initialBonusToApply;
  public final List<Ability> abilityPool;
  public final List<Reward> enlistBonusPool;

  EnlistCard(
      List<Reward> initialReward,
      List<Reward> initialBonusToApply,
      List<Ability> abilityPool,
      List<Reward> enlistBonusPool
  ) {
      this.initialReward = initialReward;
      this.initialBonusToApply = initialBonusToApply;
      this.abilityPool = abilityPool;
      this.enlistBonusPool = enlistBonusPool;
  }
}

