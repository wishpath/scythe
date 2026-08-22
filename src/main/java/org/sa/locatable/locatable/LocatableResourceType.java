package org.sa.locatable.locatable;

import java.util.Arrays;
import java.util.List;

public enum LocatableResourceType { //types of things that a tile can be producing
  // tradeable
  WOOD(null, true),
  OIL(null, true),
  FOOD(null, true),
  METAL(null, true),

  // movable
  WORKER(8, false);

  public final Integer maxAmount;
  public final boolean canGetThroughTradeAction;

  LocatableResourceType(Integer maxAmount, boolean canGetThroughTradeAction) {
    this.maxAmount = maxAmount;
    this.canGetThroughTradeAction = canGetThroughTradeAction;
  }

  public static List<LocatableResourceType> getTradeableResourceTypes() {
    return Arrays.stream(values()).filter(type -> type.canGetThroughTradeAction).toList();
  }
}