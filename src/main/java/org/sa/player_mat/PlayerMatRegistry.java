package org.sa.player_mat;

import java.util.EnumMap;
import java.util.Map;

import static org.sa.player_mat.PlayerMatType.*;

public final class PlayerMatRegistry {

  private static final Map<PlayerMatType, PlayerMatDTO> PLAYER_MAT_BY_TYPE =
      new EnumMap<>(PlayerMatType.class);

  static {
    PLAYER_MAT_BY_TYPE.put(AGRICULTURAL,
      new PlayerMatDTO(
        AGRICULTURAL,
        4,
        7,
        2,
        new ActionSpaceDTO[4]
      )
    );

    PLAYER_MAT_BY_TYPE.put(ENGINEERING,
      new PlayerMatDTO(
        ENGINEERING,
        -1,
        -1,
        -1,
        new ActionSpaceDTO[4]
      )
    );

    PLAYER_MAT_BY_TYPE.put(INDUSTRIAL,
      new PlayerMatDTO(
        INDUSTRIAL,
        -1,
        -1,
        -1,
        new ActionSpaceDTO[4]
      )
    );

    PLAYER_MAT_BY_TYPE.put(INNOVATIVE,
        new PlayerMatDTO(
            INNOVATIVE,
            -1,
            -1,
            -1,
            new ActionSpaceDTO[4]
        )
    );

    PLAYER_MAT_BY_TYPE.put(MECHANICAL,
        new PlayerMatDTO(
            MECHANICAL,
            -1,
            -1,
            -1,
            new ActionSpaceDTO[4]
        )
    );

    PLAYER_MAT_BY_TYPE.put(MILITANT,
        new PlayerMatDTO(
            MILITANT,
            -1,
            -1,
            -1,
            new ActionSpaceDTO[4]
        )
    );

    PLAYER_MAT_BY_TYPE.put(PATRIOTIC,
        new PlayerMatDTO(
            PATRIOTIC,
            -1,
            -1,
            -1,
            new ActionSpaceDTO[4]
        )
    );
  }

  public static PlayerMatDTO get(PlayerMatType type) {
    return PLAYER_MAT_BY_TYPE.get(type);
  }
}