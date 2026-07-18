package org.sa.player_mat.neighbor_bonus;

import org.sa.PlayerDTO;
import org.sa.enums.ResourceType;
import org.sa.player_mat.bottom_parts.enums_and_interfaces.BottomPartType;

public class NeighborBonus__getAttackCard__ENLIST implements NeighborBonus {

  public final BottomPartType triggeringAction = BottomPartType.ENLIST;
  private boolean enlisted;
  private int currentDeltaCards = 1;

  @Override
  public void enlist_turnOn() {
    enlisted = true;
  }

  @Override
  public boolean isEnlisted_isTurnedOn() {
    return enlisted;
  }

  public void applyToPlayer(PlayerDTO player) {
    if (!enlisted) throw new IllegalStateException(
        "Should only apply when enlisted and after trigger check."
    );
    player.addResource(ResourceType.COMBAT_CARDS, currentDeltaCards);
  }

  @Override
  public int getCurrentChangeDelta() {
    return this.currentDeltaCards; // one card is added
  }
}
