package AutomaticDoor;

public class OpenState implements AutomaticDoorState
{
  @Override
  public void pushButton(AutomaticDoor door) {
    door.setState(new CloseState());
  }
}
