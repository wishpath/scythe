package org.sa.state_change_bonus_reward_ability.cost_upgradable;

import org.sa.state_change_bonus_reward_ability.StateChange;

public interface UpgradableCost extends StateChange {

  boolean canUpgrade();

  void upgrade_lowerTheCost();
}
