package BirdWatching.observers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class BirdWatcher implements PropertyChangeListener
{
  public void says(PropertyChangeEvent evt) {
    if ("BirdFlashesWings".equals(evt.getNewValue()))
    {
      System.out.println("Bird watcher: Such beautiful wings");
    }
    else if ("BirdSings".equals(evt.getNewValue())) {
      System.out.println("Bird watcher: What a lovely singing");
    }
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    says(evt);
  }
}
