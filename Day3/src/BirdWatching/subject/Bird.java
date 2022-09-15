package BirdWatching.subject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class Bird implements PropertyChangeSubject
{
  PropertyChangeSupport propertyChangeSupport;
  private String bird = "Blue bird";

  public Bird() {
    propertyChangeSupport = new PropertyChangeSupport(this);
  }

  public void start() throws InterruptedException
  {
    Random random = new Random();
    for (int i = 0; i < 90; i++)
    {
      int rand = random.nextInt(100);

      if (rand < 8)
      {
        birdFlashesWings();
      }
      else if (rand < 12)
      {
        birdSings();
      }

      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        break;
      }
    }
  }

  public void birdFlashesWings() {
    System.out.println("Bird flashes its wings");
    propertyChangeSupport.firePropertyChange("BirdFlashesWings", bird, "BirdFlashesWings");
  }

  private void birdSings() {
    System.out.println("Bird sings a song");
    propertyChangeSupport.firePropertyChange("BirdSings", bird, "BirdSings");
  }


  @Override
  public void addPropertyChangeListener(PropertyChangeListener listener) {
    propertyChangeSupport.addPropertyChangeListener(listener);
  }


}
