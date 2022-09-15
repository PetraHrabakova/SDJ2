package DoctorsWaitingRoom.observers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Patient implements PropertyChangeListener
{
  private int id;

  public Patient(int id) {
    this.id = id;
  }

  public void setTicket(PropertyChangeEvent evt) {
    System.out.println("Patient " + id + " looks up");
    if (evt.getNewValue().equals(id))
    {
      System.out.println("Patient " + id + " goes to the doctor's office");
    }
    else {
      System.out.println("Patient " + id + " goes back to staring at his phone");
    }

  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    setTicket(evt);
  }
}
