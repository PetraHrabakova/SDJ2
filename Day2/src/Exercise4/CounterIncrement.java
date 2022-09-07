package Exercise4;

public class CounterIncrement implements Runnable
{
  Counter counter;

  public CounterIncrement(Counter counter) {
    this.counter = counter;
  }

  @Override
  public void run() {
    for (int i = 0; i < 1000000; i++) {
      counter.incrementCounter();
    }
    System.out.println(counter.getCounter());
  }
}
