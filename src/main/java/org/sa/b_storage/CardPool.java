package org.sa.b_storage;

import org.sa.enlist.EnlistCard;
import org.sa.mission.MissionCard;
import org.sa.mission.MissionDiversifyProduction;
import org.sa.mission.MissionEstablishHumanShield;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;

public class CardPool {

  EnumSet<EnlistCard> enlistCardPool = EnumSet.allOf(EnlistCard.class);
  List<MissionCard> missionCardPool = new ArrayList<>(List.of(new MissionEstablishHumanShield(), new MissionDiversifyProduction())); //TODO: add more missions later
  private static List<Integer> attackCardsPool = getNewAttackCardsPool(); // yellow attack cards: 16x+2, 12x+3, 8x+4, 6x+5
  private static final Random random = new Random();

  public static Integer drawAttackCard() {
    if (attackCardsPool.isEmpty()) attackCardsPool = getNewAttackCardsPool();
    return attackCardsPool.remove(random.nextInt(attackCardsPool.size()));
  }

  public EnlistCard drawEnlistCard() {
    if (enlistCardPool.isEmpty()) throw new IllegalStateException("Enlist card pool should not be empty");
    int index = random.nextInt(enlistCardPool.size());
    EnlistCard drawn = enlistCardPool.toArray(new EnlistCard[0])[index];
    enlistCardPool.remove(drawn);
    return drawn;
  }

  public MissionCard drawMissionCard() {
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
