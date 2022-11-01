package HeaterSystem.model;

public class Power1State implements HeaterState
{
  private static final String POWER = "1";

  @Override
  public void turnUp(Heater heater) {
    heater.setPowerState(new Power2State());
  }

  @Override
  public void turnDown(Heater heater) {
    heater.setPowerState(new Power0State());
  }

  @Override
  public String getPower() {
    return POWER;
  }

}
