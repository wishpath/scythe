package org.sa.enums;

public enum OtherResourceType {
  COINS( true, null),
  HEARTS( true, 18),
  ATTACK( true, 16),

  COMBAT_CARDS( false, null),
  MISSION_CARDS( false, null);


  public final boolean isIntegerResource;
  public final Integer maxAmountPlayerCanHave;

  OtherResourceType(boolean isIntegerResource, Integer maxAmountPlayerCanHave) {
    this.isIntegerResource = isIntegerResource;
    this.maxAmountPlayerCanHave = maxAmountPlayerCanHave;
  }
}