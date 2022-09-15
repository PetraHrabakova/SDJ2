package Exercise2;

import Exercise0.Counter;

public class Incrementer implements Runnable
{
  private TryLockCounter counter;

  public Incrementer(TryLockCounter counter) {
    this.counter = counter;
  }

  @Override
  public void run() {
    while (counter.get() < 100000) {
      counter.inc();
    }
    System.out.println(counter.get());
  }
}
