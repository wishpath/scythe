package org.sa.locatable.locatable;

public enum LocatableResourceType {
  WOOD(null, true),
  OIL(null, true),
  FOOD(null, true),
  METAL(null, true),
  WORKER(8, false);

  public final Integer maxAmount;
  public final boolean canGetThroughTradeAction;

  LocatableResourceType(Integer maxAmount, boolean canGetThroughTradeAction) {
    this.maxAmount = maxAmount;
    this.canGetThroughTradeAction = canGetThroughTradeAction;
  }
}