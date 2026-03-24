package org.sa.DTO.placeable.movable;

import org.sa.DTO.TileDTO;
import org.sa.DTO.placeable.Locatable;
import org.sa.enums.MovableType;

public interface Movable extends Locatable {
  void moveTo(TileDTO newTileDTO);
  MovableType getMovableType();
}
