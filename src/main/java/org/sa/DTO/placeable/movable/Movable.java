package org.sa.DTO.placeable.movable;

import org.sa.DTO.PlayerDTO;
import org.sa.DTO.TileDTO;
import org.sa.DTO.placeable.Locatable;
import org.sa.enums.MovableType;

public interface Movable extends Locatable {
  void moveTo(TileDTO targetTile, PlayerDTO player);
  MovableType getMovableType();
}
