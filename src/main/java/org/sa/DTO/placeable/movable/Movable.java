package org.sa.DTO.placeable.movable;

import org.sa.DTO.TileDTO;
import org.sa.DTO.placeable.Locatable;

public interface Movable extends Locatable {
  void moveTo(TileDTO newTileDTO);
}
