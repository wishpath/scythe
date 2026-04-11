package org.sa.reward.cost_upgradable;

import org.sa.DTO.PlayerDTO;

public class UpgradableCost_Produce implements UpgradableCost {

  private static final int MAX_WORKER_COUNT = 8;
  private int currentWorkerCount = 2;

  @Override
  public void applyToPlayer(PlayerDTO player) {
    if (currentWorkerCount >= 4) player.attack--;
    if (currentWorkerCount >= 5) player.hearts--;
    if (currentWorkerCount >= 6) player.coins--;
  }

  @Override
  public int getCurrentChangeDelta() {
    return this.currentWorkerCount;
  }

  @Override
  public boolean canUpgrade() {
    return currentWorkerCount < MAX_WORKER_COUNT;
  }

  @Override
  public void upgrade_lowerTheCost() {
    if (!canUpgrade()) throw new IllegalStateException("Max workers reached");
    currentWorkerCount++;
  }
}