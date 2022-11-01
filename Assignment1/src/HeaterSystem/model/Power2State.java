package HeaterSystem.model;

public class Power2State implements HeaterState
{
  private static final String POWER = "2";

  @Override
  public void turnUp(Heater heater) {
    heater.setPowerState(new Power3State(heater));
  }

  @Override
  public void turnDown(Heater heater) {
    heater.setPowerState(new Power1State());
  }

  @Override
  public String getPower() {
    return POWER;
  }

}
