package org.sa.enums;

public enum Direction {
        THIS( 0,  0),
  NORTH_EAST(-1,  1),
        EAST( 0,  1),
  SOUTH_EAST( 1,  0),
  SOUTH_WEST( 1, -1),
        WEST( 0, -1),
  NORTH_WEST(-1,  0);

  public final int deltaRow;
  public final int deltaColumn;

  Direction(int deltaRow, int deltaColumn) {
    this.deltaRow = deltaRow;
    this.deltaColumn = deltaColumn;
  }
}