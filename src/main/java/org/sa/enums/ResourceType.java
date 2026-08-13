package org.sa.enums;

public enum ResourceType {
  FOOD(true, false, null),
  METAL(true, false, null),
  OIL(true, false, null),
  WOOD(true, false, null),

  COINS(false, true, null),
  HEARTS(false, true, 18),
  ATTACK(false, true, 16),

  COMBAT_CARDS(false, false, null),
  MISSION_CARDS(false, false, null),

  WORKERS(false, false, 8);

  public final boolean canGetThroughTradeAction;
  public final boolean isIntegerResource;
  public final Integer maxAmountPlayerCanHave;

  ResourceType(boolean canGetThroughTradeAction, boolean isIntegerResource, Integer maxAmountPlayerCanHave) {
    this.canGetThroughTradeAction = canGetThroughTradeAction;
    this.isIntegerResource = isIntegerResource;
    this.maxAmountPlayerCanHave = maxAmountPlayerCanHave;
  }
}