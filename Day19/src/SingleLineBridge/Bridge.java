package SingleLineBridge;

// Example with preference a car crossing from the right

public class Bridge implements Lane
{
  private int waitingCarsFromRight, carsFromLeft, crossingCarsFromRight;

  public Bridge() {
    waitingCarsFromRight = carsFromLeft = crossingCarsFromRight = 0;
  }


  @Override public synchronized void enterFromTheLeft() {
    while (crossingCarsFromRight > 0 || carsFromLeft > 0 || waitingCarsFromRight > 0) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    carsFromLeft++;
  }

  @Override public synchronized void exitToTheRight() {
    carsFromLeft--;
    notifyAll();
  }

  @Override public synchronized void enterFromTheRight() {
    waitingCarsFromRight++;
    while (carsFromLeft > 0 || crossingCarsFromRight > 0) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    waitingCarsFromRight--;
    crossingCarsFromRight++;
  }

  @Override public synchronized void exitToTheLeft() {
    crossingCarsFromRight--;
    // Does not have to say - if (crossingCarsFromRight == 0) - because
    // there is only one car allowed to enter the bridge so it will
    // always be 0 after a car crosses the bridge
    notifyAll();
  }
}
