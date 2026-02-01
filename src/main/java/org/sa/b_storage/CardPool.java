package org.sa.b_storage;

import org.sa.mission.Mission;
import org.sa.mission.MissionDiversifyProduction;
import org.sa.mission.MissionEstablishHumanShield;

import java.util.ArrayList;
import java.util.List;

public class CardPool {
  //here all kinds of cards should be stored
  // begin with 1 enlist card
  //List<EnlistCard>
  // begin with 2 mission cards to reach certain state of the game, board state?
  List<Mission> missionCards = new ArrayList<>(List.of(new MissionEstablishHumanShield(), new MissionDiversifyProduction()));
}
