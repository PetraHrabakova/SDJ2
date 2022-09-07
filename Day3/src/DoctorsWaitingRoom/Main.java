package DoctorsWaitingRoom;

import DoctorsWaitingRoom.observers.Patient;
import DoctorsWaitingRoom.subject.WaitingRoom;

public class Main
{
  public static void main(String[] args) throws InterruptedException
  {
    WaitingRoom waitingRoom = new WaitingRoom();

    // Create 10 patients
    for (int i = 1; i <= 10; i++) {
      Patient patient = new Patient(i);
      waitingRoom.addPropertyChangeListener(patient);
    }

    waitingRoom.start();
  }

}
