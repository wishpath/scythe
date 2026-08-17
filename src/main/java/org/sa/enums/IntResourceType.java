package org.sa.enums;

public enum IntResourceType {
  COINS( null),
  HEARTS( 18),
  ATTACK( 16);

  public final Integer maxAmountPlayerCanHave;

  IntResourceType(Integer maxAmountPlayerCanHave) {
    this.maxAmountPlayerCanHave = maxAmountPlayerCanHave;
  }
}