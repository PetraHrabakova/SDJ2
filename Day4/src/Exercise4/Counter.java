package Exercise4;

public class Counter
{
  private long value;
  private long max;
  private long min;

  public Counter(long min, long max) {
    this.min = min;
    this.max = max;
    value = 0;
  }

  public synchronized void increment() {
    while (value <= max) {
      value++;
    }
  }

  public synchronized void decrement() {
    while (value >= min) {
      value--;
    }
  }


  public synchronized long getValue() {
    return value;
  }

}
