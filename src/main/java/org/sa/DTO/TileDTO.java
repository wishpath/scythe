package org.sa.DTO;

import org.sa.enums.TileType;

public class TileDTO {
  public final TileType tileType;
  public boolean isTunnel = false;
  public final int row;
  public final int column; //diagonal direction like this: "\"

  public TileDTO(TileType resource, int row, int column) {
    this.tileType = resource;
    this.row = row;
    this.column = column;
  }

  public TileDTO markAsTunnel() {
    isTunnel = true;
    return this;
  }
}