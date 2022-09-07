package RadiatorThreads;

public class Power3State implements RadiatorState
{
  private static final int POWER = 3;
  private Thread radiatorThread;
  private Radiator radiator;

  public Power3State(Radiator radiator)
  {
    radiatorThread = new Thread(new State3(radiator));
    radiatorThread.start();
    this.radiator = radiator;
  }


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
