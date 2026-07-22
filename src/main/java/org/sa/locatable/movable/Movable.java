package org.sa.locatable.movable;

import org.sa.PlayerDTO;
import org.sa.grid.TileDTO;
import org.sa.locatable.locatable.Locatable;

public interface Movable extends Locatable {
  void moveTo(TileDTO targetTile, PlayerDTO player);
  MovableType getMovableType();
  boolean isMech();
  boolean isWorker();
  boolean isCharacter();
}
