package org.sa.enlist;

import java.util.List;

public enum EnlistCard {

  //TODO: finish CONOR_AND_MAX_CLAN_ALBION enlist card
  CONOR_AND_MAX_CLAN_ALBION(
      List.of(new AbilityExample()),
      List.of(new RewardExample(), new RewardExample()),
      List.of(new AbilityExample(), new AbilityExample(), new AbilityExample(), new AbilityExample()),
      List.of(new RewardExample(), new RewardExample(), new RewardExample(), new RewardExample())
  );

  public final List<Ability> initialAbilities;
  public final List<Reward> initialBonusToApply;
  public final List<Ability> abilityPool;
  public final List<Reward> enlistBonusPool;

  EnlistCard(
      List<Ability> initialAbilities,
      List<Reward> initialBonusToApply,
      List<Ability> abilityPool,
      List<Reward> enlistBonusPool
  ) {
      this.initialAbilities = initialAbilities;
      this.initialBonusToApply = initialBonusToApply;
      this.abilityPool = abilityPool;
      this.enlistBonusPool = enlistBonusPool;
  }
}

