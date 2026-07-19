package org.sa.enums;

import org.junit.jupiter.api.Test;
import org.sa.grid.DirectionType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DirectionTest {
  @Test
  void everyDirectionHasOpposite() {
    for (DirectionType direction : DirectionType.values())
      assertNotNull(direction.opposite(), "Missing opposite for " + direction);
  }

  @Test
  void oppositeOfOppositeIsOriginal() {
    for (DirectionType direction : DirectionType.values())
      assertEquals(direction, direction.opposite().opposite(),
          "Opposite symmetry broken for " + direction);
  }

  @Test
  void oppositeDeltasAreNegated() {
    for (DirectionType direction : DirectionType.values()) {
      DirectionType opposite = direction.opposite();
      assertEquals(-direction.deltaRow, opposite.deltaRow);
      assertEquals(-direction.deltaColumn, opposite.deltaColumn);
    }
  }
}
