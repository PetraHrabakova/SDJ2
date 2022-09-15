package SoccerMatch.observers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Referee implements PropertyChangeListener
{
  public void giveYellowCard(PropertyChangeEvent evt) {
    if ("OldBoysRoughTackle".equals(evt.getNewValue()))
    {
      System.out.println("Referee gives Old Boys a yellow card for a rough tackle.");
    }
    else if ("DreamTeamRoughTackle".equals(evt.getNewValue())) {
      System.out.println("Referee gives Dream Team a yellow card for a rough tackle");
    }
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    giveYellowCard(evt);
  }
}
