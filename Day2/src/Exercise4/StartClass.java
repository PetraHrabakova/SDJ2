package Exercise4;

public class StartClass
{
  public static void main(String[] args)
  {
    Counter counter = new Counter();
    Thread counter1Thread = new Thread(new CounterIncrement(counter));
    Thread counter2Thread = new Thread(new CounterIncrement(counter));

    counter1Thread.start();
    counter2Thread.start();
  }
}
