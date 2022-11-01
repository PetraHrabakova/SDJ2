package HeaterSystem.model;

public class Power0State implements HeaterState
{
  private static final String POWER = "Off";

  @Override
  public void turnUp(Heater heater) {
    heater.setPowerState(new Power1State());
  }

  @Override
  public void turnDown(Heater heater) {
    System.out.println("The heater cannot be turned down anymore");
  }

  @Override
  public String getPower() {
    return POWER;
  }

}
