package Exercise2;

public class Main
{
  public static void main(String[] args)
  {
    TryLockCounter c = new TryLockCounter();

    Thread t1 = new Thread(new Incrementer(c));
    Thread t2 = new Thread(new Incrementer(c));

    t1.start();
    t2.start();
  }
}
