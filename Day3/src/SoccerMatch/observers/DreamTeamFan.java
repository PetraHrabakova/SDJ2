package SoccerMatch.observers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DreamTeamFan implements PropertyChangeListener
{
  public void scream(PropertyChangeEvent evt) {
    if ("DreamTeamScore".equals(evt.getNewValue()))
    {
      System.out.println("Dream team fans: YEEEAAAH!");
    }
    else if ("OldBoysScore".equals(evt.getNewValue())) {
      System.out.println("Dream team fans: BUUUUU!");
    }
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    scream(evt);
  }
}
