package AutomaticDoor;

public class CloseState implements AutomaticDoorState
{
  @Override
  public void pushButton(AutomaticDoor door) {
    door.setState(new OpenState());
  }
}
