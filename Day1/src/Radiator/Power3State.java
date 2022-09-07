package Radiator;

public class Power3State implements RadiatorState
{
  private static final int POWER = 3;

  // public Power3State(Radiator radiator) {}
  @Override
  public void turnUp(Radiator radiator) {
    System.out.println("The radiator cannot be turned up anymore");
  }

  @Override
  public void turnDown(Radiator radiator) {
    radiator.setPowerState(new Power2State());
  }

  @Override
  public int getPower() {
    return POWER;
  }

}
