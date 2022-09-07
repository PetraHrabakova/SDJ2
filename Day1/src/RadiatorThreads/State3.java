package RadiatorThreads;

public class State3 implements Runnable
{
  private Radiator radiator;

  public State3 (Radiator radiator) {
    this.radiator = radiator;
  }

  @Override public void run() {
    try {
      Thread.sleep(10000);
      radiator.setPowerState(new Power2State());
    }
    catch (InterruptedException e) {
      System.out.println("Dead");
    }

  }
}
