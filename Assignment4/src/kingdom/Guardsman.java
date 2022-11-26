package kingdom;

import valuables.ValuablesMultiton;
import java.util.ArrayList;

public class Guardsman implements TreasureRoomDoor
{
  private TreasureRoom treasureRoom;
  private ArrayList<ValuablesMultiton> valuables;

  public Guardsman() {
    treasureRoom = new TreasureRoom();
    valuables = new ArrayList<>();
  }

  @Override public synchronized void getAccessToAddToTreasureRoom(Object person) {
    treasureRoom.getAccessToAddToTreasureRoom(person);
  }

  @Override public synchronized void releaseAccessToAddToTreasureRoom(Object person) {
    treasureRoom.releaseAccessToAddToTreasureRoom(person);
  }

  @Override public synchronized void getAccessToTakeFromTreasureRoom(Object person) {
    treasureRoom.getAccessToTakeFromTreasureRoom(person);
  }

  @Override public synchronized void releaseAccessToTakeFromTreasureRoom(Object person) {
    treasureRoom.releaseAccessToTakeFromTreasureRoom(person);
  }

  @Override public synchronized void getAccessToSeeTheTreasureRoom(Object person) {
    treasureRoom.getAccessToSeeTheTreasureRoom(person);
  }

  @Override public synchronized void releaseAccessToSeeTheTreasureRoom(Object person) {
    treasureRoom.releaseAccessToSeeTheTreasureRoom(person);
  }

  public synchronized void addToTreasureRoom(ArrayList<ValuablesMultiton> deliveredItems) {
    valuables.addAll(deliveredItems);
  }

  public synchronized ValuablesMultiton takeFromTreasureRoom() {
    return valuables.remove(0);
  }

  public synchronized int getAmountOfTreasures() {
    return valuables.size();
  }

}
