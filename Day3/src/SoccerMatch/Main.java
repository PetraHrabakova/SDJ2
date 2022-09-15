package SoccerMatch;

import SoccerMatch.observers.*;
import SoccerMatch.subject.SoccerMatch;

public class Main
{
  public static void main(String[] args) throws InterruptedException
  {
    SoccerMatch soccerMatch = new SoccerMatch();
    DreamTeamFan fan1 = new DreamTeamFan();
    OldBoysFan fan2 = new OldBoysFan();
    AngryCoachDreamTeam coachDreamTeam = new AngryCoachDreamTeam();
    Referee referee = new Referee();
    ScoreBoard scoreBoard = new ScoreBoard();

    soccerMatch.addPropertyChangeListener(fan1);
    soccerMatch.addPropertyChangeListener(fan2);
    soccerMatch.addPropertyChangeListener(coachDreamTeam);
    soccerMatch.addPropertyChangeListener(referee);
    soccerMatch.addPropertyChangeListener(scoreBoard);

    soccerMatch.start();
  }
}

