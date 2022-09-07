package AutomaticDoor;

public class AutomaticDoor
{
  private AutomaticDoorState currentState = new CloseState();

  public void setState(AutomaticDoorState currentState) {
    this.currentState = currentState;
  }

  public void pushButton(AutomaticDoor door) {
    currentState.pushButton(this);
  }






}
