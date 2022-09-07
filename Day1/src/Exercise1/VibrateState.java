package Exercise1;

public class VibrateState implements PhoneState
{
  @Override
  public void onReceiveMessage(String txt, Phone phone) {
    System.out.println(txt);
  }

  @Override
  public void onReceiveCall(Phone phone) {
    phone.vibrate();
  }

  @Override
  public void onVolumeButtonUp(Phone phone) {
    int vol = phone.getVolume();
    //Why is it not necessary to check whether we are on sound or not?
    if(vol < 100) {
      phone.turnVolumeUp();
    }
  }

  @Override
  public void onVolumeButtonDown(Phone phone) {
    int vol = phone.getVolume();
    if (vol > 1) {
      phone.turnVolumeDown();
    } else {
      phone.setState(new SilentState());
    }
  }
}
