package org.sa.DTO;

import org.sa.enums.TileType;

public class TileDTO {
  public final TileType tileType;
  public final boolean isTunnel;
  public final int row;
  public final int column;

  public TileDTO(TileType resource, boolean isTunnel, int row, int column) {
    this.tileType = resource;
    this.isTunnel = isTunnel;
    this.row = row;
    this.column = column;
  }
}