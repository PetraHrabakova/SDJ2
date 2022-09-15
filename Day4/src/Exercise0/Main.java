package Exercise0;

public class Main
{
  public static void main(String[] args)
  {
    Counter c = new Counter();
    Thread t1 = new Thread(new Incrementer(c));
    Thread t2 = new Thread(new Incrementer(c));

    t1.start();
    t2.start();
  }
}
