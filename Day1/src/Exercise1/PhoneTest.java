package Exercise1;

public class PhoneTest
{
  public static void main(String[] args)
  {
    Phone phone = new Phone();
    phone.goToSilentState();
    phone.turnVolumeUp();
    phone.turnVolumeUp();
    phone.turnVolumeDown();
    phone.receiveMessage("Hello");
    System.out.println(phone.getVolume());
    phone.volumeUpButton();
    phone.receiveMessage("Yo sup");
  }
}
