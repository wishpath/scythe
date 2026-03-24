package org.sa.b_storage;

import org.sa.enums.FactionMat;
import org.sa.enums.PlayerMat;
import org.sa.mission.MissionCard;
import org.sa.mission.MissionDiversifyProduction;
import org.sa.mission.MissionEstablishHumanShield;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;

public class CardPool {

  private static EnumSet<FactionMat> factionMapPool = EnumSet.allOf(FactionMat.class);
  private static EnumSet<PlayerMat> playerMatPool = EnumSet.allOf(PlayerMat.class);
  private static List<MissionCard> missionCardPool = new ArrayList<>(List.of(new MissionEstablishHumanShield(), new MissionDiversifyProduction())); //TODO: add more missions later
  private static List<Integer> attackCardsPool = getNewAttackCardsPool(); // yellow attack cards: 16x+2, 12x+3, 8x+4, 6x+5
  private static final Random random = new Random();

  public static Integer drawAttackCard() {
    if (attackCardsPool.isEmpty()) attackCardsPool = getNewAttackCardsPool();
    return attackCardsPool.remove(random.nextInt(attackCardsPool.size()));
  }

  public static FactionMat drawEnlistCard() {
    if (factionMapPool.isEmpty()) throw new IllegalStateException("Enlist card pool should not be empty");
    int index = random.nextInt(factionMapPool.size());
    FactionMat drawn = factionMapPool.toArray(new FactionMat[0])[index];
    factionMapPool.remove(drawn);
    return drawn;
  }

  public static PlayerMat drawFactionBoard() {
    if (playerMatPool.isEmpty()) throw new IllegalStateException("Faction board pool should not be empty");
    int index = random.nextInt(playerMatPool.size());
    PlayerMat drawn = playerMatPool.toArray(new PlayerMat[0])[index];
    playerMatPool.remove(drawn);
    return drawn;
  }

  public static MissionCard drawMissionCard() {
    if (missionCardPool.isEmpty()) throw new IllegalStateException("Mission card pool should not be empty");
    return missionCardPool.remove(random.nextInt(missionCardPool.size()));
  }

  private static List<Integer> getNewAttackCardsPool() {
    List<Integer> attackCardsPool = new ArrayList<>();
    for (int i = 0; i < 16; i++) attackCardsPool.add(2);
    for (int i = 0; i < 12; i++) attackCardsPool.add(3);
    for (int i = 0; i < 8; i++) attackCardsPool.add(4);
    for (int i = 0; i < 6; i++) attackCardsPool.add(5);
    return attackCardsPool;
  }
}
