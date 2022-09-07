package Exercise9;

import java.util.Random;

public class Rabbit implements Runnable
{
  private Thread turtle;
  private Counter rabbitCounter;
  private Counter turtleCounter;

  public Rabbit(Thread turtle, Counter rabbitCounter, Counter turtleCounter)
  {
    this.turtle = turtle;
    this.rabbitCounter = rabbitCounter;
    this.turtleCounter = turtleCounter;
  }

  @Override
  public void run()
  {
    while (rabbitCounter.getRabbitCounter() < 1000)
    {
      rabbitCounter.incrementRabbitCounter();

      while ((rabbitCounter.getRabbitCounter() - turtleCounter.getTurtleCounter()) >= 50)
      {
        Random r = new Random();
        int i = r.nextInt(1000);

        try
        {
          System.out.println("Rabbit is sleeping now");
          Thread.sleep(i);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }
    }
    turtle.interrupt();
  }
}
