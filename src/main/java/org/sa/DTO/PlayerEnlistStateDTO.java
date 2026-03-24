package org.sa.DTO;

import org.sa.enums.FactionMat;
import org.sa.reward.StateChange;

import java.util.HashSet;
import java.util.Set;

public class PlayerEnlistStateDTO { //is owned by player
  public final FactionMat card;
  public final Set<StateChange> remainingAbilities;
  public final Set<StateChange> remainingRewards;

  public PlayerEnlistStateDTO(FactionMat card) {
    this.card = card;
    this.remainingAbilities = new HashSet<>(card.abilityPoolToUnlock);
    this.remainingRewards = new HashSet<>(card.bonusPoolToUnlock);
  }
}
