package BirdWatching.observers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class BlindBirdWatcher implements PropertyChangeListener
{
  public void says(PropertyChangeEvent evt) {
    if ("BirdSings".equals(evt.getNewValue())) {
      System.out.println("Blind bird watcher: Beautiful singing");
    }
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    says(evt);
  }
}
