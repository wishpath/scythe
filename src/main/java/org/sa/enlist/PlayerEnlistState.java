package org.sa.enlist;

import org.sa.reward.Reward;

import java.util.HashSet;
import java.util.Set;

public class PlayerEnlistState { //is owned by player
  // TODO: use initial abilities and initial rewards as card gets picked ans assigned to the player,
  //  while the pools of abilities and rewards should be here, for use during enlist action

  public final EnlistCard card;
  public final Set<Reward> remainingAbilities;
  public final Set<Reward> remainingRewards;

  public PlayerEnlistState(EnlistCard card) {
    this.card = card;
    this.remainingAbilities = new HashSet<>(card.abilityPoolToUnlock);
    this.remainingRewards = new HashSet<>(card.bonusPoolToUnlock);
  }
}
