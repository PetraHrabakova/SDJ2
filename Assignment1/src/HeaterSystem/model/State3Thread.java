package HeaterSystem.model;

public class State3Thread implements Runnable
{
  private Heater heater;

  public State3Thread(Heater heater) {
    this.heater = heater;
  }

  @Override public void run() {
    try {
      // Heater waits for 40 seconds before turning down to state 2
      Thread.sleep(40000);
      System.out.println("The heater is too hot. Turning down to state 2");
      // Sleep is over, heater goes down to state 2
      heater.setPowerState(new Power2State());
      System.out.println("Power state: " + heater.getPower());
    }
    catch (InterruptedException e) {
      System.out.println("Thread interrupted, timer stopped");
    }

  }
}
