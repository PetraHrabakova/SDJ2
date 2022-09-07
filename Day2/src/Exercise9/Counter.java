package Exercise9;

public class Counter
{
  private int turtleCounter;
  private int rabbitCounter;


  public Counter() {
    turtleCounter = 1;
    rabbitCounter = 1;
  }

  public void incrementTurtleCounter () {
    System.out.println("This is turtle counter: " + turtleCounter);
      turtleCounter++;
  }

  public void incrementRabbitCounter() {
    System.out.println("This is rabbit counter: " + rabbitCounter);
      rabbitCounter++;
  }

  public int getTurtleCounter() {
    return turtleCounter;
  }

  public int getRabbitCounter() {
    return rabbitCounter;
  }
}
