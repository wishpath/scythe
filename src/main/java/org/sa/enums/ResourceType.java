package org.sa.enums;

public enum ResourceType {
  FOOD(true, true),
  METAL(true, true),
  OIL(true, true),
  WOOD(true, true),

  COINS(false, true),
  HEARTS(false, true),
  ATTACK(false, true),

  COMBAT_CARDS(false, false),
  MISSION_CARDS(false, false);

  public final boolean canGetThroughTradeAction;
  public final boolean isIntegerResource;

  ResourceType(boolean canGetThroughTradeAction, boolean isIntegerResource) {
    this.canGetThroughTradeAction = canGetThroughTradeAction;
    this.isIntegerResource = isIntegerResource;
  }
}