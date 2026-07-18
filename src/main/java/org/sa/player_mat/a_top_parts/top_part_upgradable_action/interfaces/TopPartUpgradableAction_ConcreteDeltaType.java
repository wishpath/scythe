package org.sa.player_mat.a_top_parts.top_part_upgradable_action.interfaces;

import org.sa.PlayerDTO;

public interface TopPartUpgradableAction_ConcreteDeltaType extends TopPartUpgradableAction {
  void applyToPlayer(PlayerDTO player);
}
