package SoccerMatch.observers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ScoreBoard implements PropertyChangeListener
{
  private int scoreOldBoys;
  private int scoreDreamTeam;

  public ScoreBoard() {
    scoreDreamTeam = 0;
    scoreOldBoys = 0;
  }
  public void scoreBoardChange(PropertyChangeEvent evt) {
    if ("OldBoysScore".equals(evt.getNewValue()))
    {
      scoreOldBoys++;
      System.out.println("Score: ");
      System.out.println("Old Boys - " + scoreOldBoys);
      System.out.println("Dream Team - " + scoreDreamTeam);
    }
    else if ("DreamTeamScore".equals(evt.getNewValue())) {
      scoreDreamTeam++;
      System.out.println("Score: ");
      System.out.println("Old Boys - " + scoreOldBoys);
      System.out.println("Dream Team - " + scoreDreamTeam);
    }
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    scoreBoardChange(evt);
  }
}
