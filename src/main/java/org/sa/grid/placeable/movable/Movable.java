package org.sa.grid.placeable.movable;

import org.sa.PlayerDTO;
import org.sa.grid.TileDTO;
import org.sa.grid.placeable.Locatable;
import org.sa.enums.locatable_and_grid_enum.MovableType;

public interface Movable extends Locatable {
  void moveTo(TileDTO targetTile, PlayerDTO player);
  MovableType getMovableType();
  boolean isMech();
  boolean isWorker();
  boolean isCharacter();
}
