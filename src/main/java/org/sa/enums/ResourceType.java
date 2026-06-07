package org.sa.enums;

public enum ResourceType {
  FOOD(false),
  METAL(false),
  OIL(false),
  WOOD(false),

  COINS(true),
  HEARTS(true),
  ATTACK(true);

  public final boolean canGetThroughTradeAction;

  ResourceType(boolean canGetThroughTradeAction) {
    this.canGetThroughTradeAction = canGetThroughTradeAction;
  }
}