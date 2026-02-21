package org.sa.enlist;

import org.sa.reward.Reward;

import java.util.HashSet;
import java.util.Set;

public class PlayerEnlistState { //is owned by player
  public final EnlistCard card;
  public final Set<Reward> remainingAbilities;
  public final Set<Reward> remainingRewards;

  public PlayerEnlistState(EnlistCard card) {
    this.card = card;
    this.remainingAbilities = new HashSet<>(card.abilityPoolToUnlock);
    this.remainingRewards = new HashSet<>(card.bonusPoolToUnlock);
  }
}
