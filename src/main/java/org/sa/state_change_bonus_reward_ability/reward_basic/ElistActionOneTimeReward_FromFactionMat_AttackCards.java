package org.sa.state_change_bonus_reward_ability.reward_basic;

import org.sa.DTO.PlayerDTO;
import org.sa.b_storage.CardPool;
import org.sa.state_change_bonus_reward_ability.StateChange;

public class ElistActionOneTimeReward_FromFactionMat_AttackCards implements StateChange {
  private int deltaAttackCardAmount;

  public ElistActionOneTimeReward_FromFactionMat_AttackCards(int deltaAttackCardAmount) {
    this.deltaAttackCardAmount = deltaAttackCardAmount;
  }

  @Override
  public void applyToPlayer(PlayerDTO player) {
    for (int i = 0; i < deltaAttackCardAmount; i++) {
      player.attackCards.add(CardPool.drawAttackCard());
    }
  }

  @Override
  public int getCurrentChangeDelta() {
    return deltaAttackCardAmount;
  }
}
