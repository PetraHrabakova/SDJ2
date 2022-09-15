package SoccerMatch.observers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AngryCoachDreamTeam implements PropertyChangeListener
{
  public void scream(PropertyChangeEvent evt) {
    if ("DreamTeamScore".equals(evt.getNewValue()))
    {
      System.out.println("Dream Team's Coach: YEEEAAAH!");
    }
    else if ("OldBoysRoughTackle".equals(evt.getNewValue())) {
      System.out.println("Dream Team's Coach: Old grandpas off the field!");
    }
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    scream(evt);
  }
}
