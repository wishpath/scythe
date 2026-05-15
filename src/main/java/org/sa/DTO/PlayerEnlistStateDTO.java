package org.sa.DTO;

import org.sa.enums.FactionMat;
import org.sa.state_change_bonus_reward_ability.StateChange;

import java.util.HashSet;
import java.util.Set;

public class PlayerEnlistStateDTO { //is owned by player
  public FactionMat card;
  public Set<StateChange> remainingAbilities;
  public Set<StateChange> remainingRewards;
  public boolean getsRewardedByNeighbourAction_UPGRADE_getsAttack = false;
  public boolean getsRewardedByNeighbourAction_DEPLOY_getsCoin = false;
  public boolean getsRewardedByNeighbourAction_BUILD_getsHeart = false;
  public boolean getsRewardedByNeighbourAction_Enlist_getsAttackCard = false;

  public PlayerEnlistStateDTO(FactionMat card) {
    this.card = card;
    this.remainingAbilities = new HashSet<>(card.unlockableByMechDeploy_ongoingAbilitiesPool);
    this.remainingRewards = new HashSet<>(card.unlockableByEnlistAction_oneTimeRewardPool);
  }
}
