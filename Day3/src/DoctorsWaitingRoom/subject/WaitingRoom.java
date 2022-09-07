package DoctorsWaitingRoom.subject;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class WaitingRoom implements PropertyChangeSubject
{
  PropertyChangeSupport propertyChangeSupport;

  private int[] tickets = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
  private int count = 0;
  private int currentTicket;

  public WaitingRoom() {
    propertyChangeSupport = new PropertyChangeSupport(this);
  }

  public void start() throws InterruptedException {
    // Do 10 iterations - could be more or less, depends how many times you wanna test it
    for (int i = 0; i < 10; i++) {
      // Make the thread sleep for a bit
      Thread.sleep(1000);
      // Create random number to pick from the array with ticket numbers
      Random rn = new Random();
      // Random number between 0 and 9
      count = rn.nextInt(10);
      // Tbh it could just be - currentTicket = count (because all
      // We want is a random number of the ticket) but to keep
      // The idea of an array with observers, we keep the array
      int previous = currentTicket;
      currentTicket = tickets[count];
      System.out.println("\nTicket is " + currentTicket);

      ticketChanged(previous, currentTicket);
    }
  }

  private void ticketChanged(int previous, int current) {
    propertyChangeSupport.firePropertyChange("TicketChanged", previous, current);
  }

  @Override
  public void addPropertyChangeListener(PropertyChangeListener listener) {
    propertyChangeSupport.addPropertyChangeListener(listener);
    listener.propertyChange(new PropertyChangeEvent(this, "TicketChanged", currentTicket, currentTicket));
  }

}
