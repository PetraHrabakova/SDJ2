package HeaterSystem.model;


public class Heater
{
  private HeaterState currentState = new Power0State();

  public void turnUp() {
    currentState.turnUp(this);
  }

  public void turnDown() {
    currentState.turnDown(this);
  }

  public String getPower() {
    return currentState.getPower();
  }

  public void setPowerState(HeaterState currentState) {
    this.currentState = currentState;
  }


}
