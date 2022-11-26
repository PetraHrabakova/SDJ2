package kingdom;

public interface TreasureRoomDoor {
  void getAccessToAddToTreasureRoom(Object person);
  void releaseAccessToAddToTreasureRoom(Object person);
  void getAccessToTakeFromTreasureRoom(Object person);
  void releaseAccessToTakeFromTreasureRoom(Object person);
  void getAccessToSeeTheTreasureRoom(Object person);
  void releaseAccessToSeeTheTreasureRoom(Object person);
  }
