package org.sa.b_storage;

import org.sa.mission.Mission;
import org.sa.mission.MissionDiversifyProduction;
import org.sa.mission.MissionEstablishHumanShield;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardPool {
  //here all kinds of cards should be stored
  // begin with 1 enlist card
  //List<EnlistCard>
  // begin with 2 mission cards to reach certain state of the game, board state?
  List<Mission> missionCards = new ArrayList<>(List.of(new MissionEstablishHumanShield(), new MissionDiversifyProduction()));
  // yellow attack cards: 16x+2, 12x+3, 8x+4, 6x+5
  private static List<Integer> attackCardsPool = getNewAttackCardsPool() ;
  private static final Random random = new Random();

  public static Integer drawAttackCard() {
    if (attackCardsPool.isEmpty()) attackCardsPool = getNewAttackCardsPool();
    return attackCardsPool.remove(random.nextInt(attackCardsPool.size()));
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
