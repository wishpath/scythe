package org.sa.player_mat;

import org.sa.player_mat.a_top_parts.TopPart_chooseBetweenAttack_PointsOrCards;
import org.sa.player_mat.a_top_parts.TopPart_chooseBetweenMoveOrGainCoins;
import org.sa.player_mat.a_top_parts.TopPart_chooseBetweenTradeGoodsOrGainHearts;
import org.sa.player_mat.a_top_parts.TopPart_noChoosing_Produce;
import org.sa.player_mat.a_top_parts.enums_and_interfaces.TYPE__TopPart__TopPartChooseActionArray__ActionSpace;
import org.sa.player_mat.bottom_parts.BottomPart_Build;
import org.sa.player_mat.bottom_parts.BottomPart_Deploy;
import org.sa.player_mat.bottom_parts.BottomPart_actionOfUpgrade;
import org.sa.player_mat.bottom_parts.enums_and_interfaces.BottomPartType;
import org.sa.state_change_bonus_reward_ability.cost_upgradable.UpgradableCost_Food;
import org.sa.state_change_bonus_reward_ability.cost_upgradable.UpgradableCost_Metal;
import org.sa.state_change_bonus_reward_ability.cost_upgradable.UpgradableCost_Wood;

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
          new ActionSpaceDTO[] { //action-space — left-to-right

              // left action space
              new ActionSpaceDTO(
                  TYPE__TopPart__TopPartChooseActionArray__ActionSpace.CHOOSE__MOVE__GAIN_COINS, //Action top type
                  new TopPart_chooseBetweenMoveOrGainCoins(),
                  new BottomPart_actionOfUpgrade(AGRICULTURAL)
              ),

              // mid-left action space
              new ActionSpaceDTO(
                  TYPE__TopPart__TopPartChooseActionArray__ActionSpace.CHOOSE__TRADE__GAIN_HEARTS, //Action top type
                  new TopPart_chooseBetweenTradeGoodsOrGainHearts(),
                  new BottomPart_Deploy(AGRICULTURAL)
              ),


              // mid-right action space
              new ActionSpaceDTO(
                  TYPE__TopPart__TopPartChooseActionArray__ActionSpace.NO_CHOOSE__PRODUCE,
                  new TopPart_noChoosing_Produce(),
                  new BottomPart_Build(AGRICULTURAL)
              ),


              // right action space
              new ActionSpaceDTO(
                  TYPE__TopPart__TopPartChooseActionArray__ActionSpace.CHOOSE__POWER__COMBAT_CARDS,
                  new TopPart_chooseBetweenAttack_PointsOrCards(),
                  BottomPartType.ENLIST,
                  new UpgradableCost_Food(-3,-1),
                  1
              ),
          }
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