package SingleLineBridge;

public class Car implements Runnable
{
  private int crossingTime;
  private int waitingTime;
  private String direction;
  private Bridge bridge;

  public Car(Bridge bridge, int crossingTime, int waitingTime,
      String direction)
  {
    this.bridge = bridge;
    this.crossingTime = crossingTime;
    this.waitingTime = waitingTime;
    this.direction = direction;
  }

  @Override public void run()
  {
    while (true)
    {
      if (direction.equals("right"))
      {
        try {
          // Cross from the right
          bridge.enterFromTheRight();
          System.out.println("Car is crossing from the right");
          Thread.sleep(crossingTime);
          bridge.exitToTheLeft();
          System.out.println("Car exited to the left");

          // Wait before you cross again
          Thread.sleep(waitingTime);

          // Cross from the left
          bridge.enterFromTheLeft();
          System.out.println("Car turned around and crossing from the left");
          Thread.sleep(crossingTime);
          bridge.exitToTheRight();
          System.out.println("Car exited to the right");

        } catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }

      else if (direction.equals("left")) {
        try {
          // Cross from the left
          bridge.enterFromTheLeft();
          System.out.println("Car is crossing from the left");
          Thread.sleep(crossingTime);
          bridge.exitToTheRight();
          System.out.println("Car exited to the right");

          // Wait before you cross again
          Thread.sleep(waitingTime);

          // Cross from the right
          bridge.enterFromTheLeft();
          System.out.println("Car turned around and crossing from the right");
          Thread.sleep(crossingTime);
          bridge.exitToTheRight();
          System.out.println("Car exited to the left");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
