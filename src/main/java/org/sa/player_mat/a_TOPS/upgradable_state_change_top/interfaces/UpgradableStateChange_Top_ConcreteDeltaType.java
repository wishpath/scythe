package org.sa.player_mat.a_TOPS.upgradable_state_change_top.interfaces;

import org.sa.DTO.PlayerDTO;

public interface UpgradableStateChange_Top_ConcreteDeltaType extends UpgradableStateChange_Top {
  void applyToPlayer(PlayerDTO player);
}
