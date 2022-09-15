package Exercise4;

public class Main
{
  public static void main(String[] args)
  {
    Counter counter = new Counter(1, 99);
    Thread cd1 = new Thread(new CounterDecrementer(counter, 20));
    Thread cd2 = new Thread(new CounterDecrementer(counter, 20));
    Thread ci1 = new Thread(new CounterIncrementer(counter, 20));
    Thread ci2 = new Thread(new CounterIncrementer(counter, 20));

    ci1.setName("increment1");
    ci1.start();

    cd1.setName("decrement1");
    cd1.start();

    ci2.setName("increment2");
    ci2.start();

    cd2.setName("decrement2");
    cd2.start();


  }
}
