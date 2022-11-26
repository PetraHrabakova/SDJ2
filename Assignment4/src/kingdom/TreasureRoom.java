package kingdom;

import valuables.TransporterConsumer;

public class TreasureRoom implements TreasureRoomDoor
{
  private int kingDoingHisThing;
  private int waitingKing;
  private int waitingAccountants;
  private int countingAccountants;
  private int waitingTransporters;
  private int deliveringTransporters;

  public TreasureRoom() {
    kingDoingHisThing = waitingKing = waitingAccountants = countingAccountants = waitingTransporters = deliveringTransporters = 0;
  }

  @Override public synchronized void getAccessToAddToTreasureRoom(Object person) {
    if (person instanceof King) {
      waitingKing++;
      while (deliveringTransporters > 0) {
        try {
          wait();
        } catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }
      waitingKing--;
      kingDoingHisThing++;   // Let king enter right away, don't wait
    }
    else if (person instanceof TransporterConsumer) {
      waitingTransporters++;
      //System.out.println("WAITING TRANSPORTERS: " + waitingTransporters);
      while (waitingKing > 0 || kingDoingHisThing > 0 || deliveringTransporters > 0 || countingAccountants > 0) {
        try {
          wait();
        } catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }
      waitingTransporters--;
      //System.out.println("WAITING TRANSPORTERS: " + waitingTransporters);
      deliveringTransporters++;
    }
  }

  @Override public synchronized void releaseAccessToAddToTreasureRoom(Object person) {
    if (person instanceof King) {
      kingDoingHisThing--;
    }
    else if (person instanceof TransporterConsumer) {
      deliveringTransporters--;
      //System.out.println("TRANSPORTER RELEASED THE LOCK. deliveringTransporter: " + deliveringTransporters);
    }
    if (kingDoingHisThing == 0 || deliveringTransporters == 0) {
      notifyAll();
    }
  }

  @Override public synchronized void getAccessToTakeFromTreasureRoom(Object person) {
    if (person instanceof King) {
      waitingKing++;
      //System.out.println("WAITING KING: " + waitingKing);
      while (deliveringTransporters > 0 || countingAccountants > 0) {
        try {
          wait();
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }
      waitingKing--;
      //System.out.println("WAITING KING: " + waitingKing);
      kingDoingHisThing++;
    }
    else {
      System.out.println("Unauthorized person is trying to get into the treasure room");
    }
  }

  @Override public synchronized void releaseAccessToTakeFromTreasureRoom(Object person) {
    kingDoingHisThing--;
    //System.out.println("KING RELEASED THE LOCK. kingDoingKisThing: " + kingDoingHisThing);
    notifyAll();
  }

  @Override public synchronized void getAccessToSeeTheTreasureRoom(Object person) {
    if (person instanceof Accountant) {
      waitingAccountants++;
      //System.out.println("WAITING ACCOUNTANT: " + waitingAccountants);
      while (kingDoingHisThing > 0 || waitingKing > 0 || waitingTransporters > 0 || deliveringTransporters > 0) {
        try {
          wait();
        } catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }
      countingAccountants = waitingAccountants;   // Let all accountants in
      waitingAccountants = 0;
    }
  }

  @Override public synchronized void releaseAccessToSeeTheTreasureRoom(Object person) {
    if (person instanceof Accountant) {
      countingAccountants--;
      //System.out.println("ACCOUNTANT RELEASED THE LOCK. countingAccountant: " + countingAccountants);

    }
    if (countingAccountants == 0 ) {
      notifyAll();
    }
  }

}
