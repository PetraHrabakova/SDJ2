package BirdWatching;

import BirdWatching.observers.BirdWatcher;
import BirdWatching.observers.BlindBirdWatcher;
import BirdWatching.subject.Bird;

public class Main
{
  public static void main(String[] args) throws InterruptedException
  {
    Bird bird = new Bird();
    BirdWatcher birdWatcher = new BirdWatcher();
    BlindBirdWatcher blindBirdWatcher = new BlindBirdWatcher();

    bird.addPropertyChangeListener(birdWatcher);
    bird.addPropertyChangeListener(blindBirdWatcher);

    bird.start();

  }
}
