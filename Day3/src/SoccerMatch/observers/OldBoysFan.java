package SoccerMatch.observers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class OldBoysFan implements PropertyChangeListener
{
  public void scream(PropertyChangeEvent evt) {
    if ("OldBoysScore".equals(evt.getNewValue()))
    {
      System.out.println("Old boys fans: YEEEAAAH!");
    }
    else if ("DreamTeamScore".equals(evt.getNewValue())) {
      System.out.println("Old boys fans: BUUUUU!");
    }
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    scream(evt);
  }
}
