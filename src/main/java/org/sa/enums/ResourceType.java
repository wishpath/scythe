package org.sa.enums;

public enum ResourceType {
  FOOD(true),
  METAL(true),
  OIL(true),
  WOOD(true),

  COINS(false),
  HEARTS(false),
  ATTACK(false);

  public final boolean canGetThroughTradeAction;

  ResourceType(boolean canGetThroughTradeAction) {
    this.canGetThroughTradeAction = canGetThroughTradeAction;
  }
}