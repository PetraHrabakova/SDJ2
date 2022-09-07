package Exercise9;

public class Turtle implements Runnable
{
  private Counter counter;

  public Turtle(Counter counter) {
    this.counter = counter;
  }

  @Override
  public void run() {
    try {
      while (counter.getTurtleCounter() < 1000)
      {
        Thread.sleep(10);
        counter.incrementTurtleCounter();
      }
    } catch (InterruptedException e) {
      System.out.println("Rabbit won");
    }
    System.out.println("Turtle won");
  }
}


