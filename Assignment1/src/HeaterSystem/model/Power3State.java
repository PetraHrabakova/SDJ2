package HeaterSystem.model;

public class Power3State implements HeaterState
{
  private static final String POWER = "3";
  private final Thread heaterThread;

  public Power3State(Heater heater)
  {
    heaterThread = new Thread(new State3Thread(heater));
    heaterThread.start();
    System.out.println("Power state 3 has been activated, starting a timer for 40 seconds");
  }

  @Override
  public void turnUp(Heater heater) {
    System.out.println("The heater cannot be turned up anymore");
  }

  @Override
  public void turnDown(Heater heater) {
    heater.setPowerState(new Power2State());
    heaterThread.interrupt();
  }

  @Override
  public String getPower() {
    return POWER;
  }

}
