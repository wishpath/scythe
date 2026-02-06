package org.sa.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DirectionTest {
  @Test
  void everyDirectionHasOpposite() {
    for (Direction direction : Direction.values())
      assertNotNull(direction.opposite(), "Missing opposite for " + direction);
  }

  @Test
  void oppositeOfOppositeIsOriginal() {
    for (Direction direction : Direction.values())
      assertEquals(direction, direction.opposite().opposite(),
          "Opposite symmetry broken for " + direction);
  }

  @Test
  void oppositeDeltasAreNegated() {
    for (Direction direction : Direction.values()) {
      Direction opposite = direction.opposite();
      assertEquals(-direction.deltaRow, opposite.deltaRow);
      assertEquals(-direction.deltaColumn, opposite.deltaColumn);
    }
  }
}
