package Exercise8;

public class TestClass
{
  public static void main(String[] args)
  {
    Thread run1 = new Thread(new RunnableClass(0, 25));
    Thread run2 = new Thread(new JoiningClass(26, 50, run1));
    Thread run3 = new Thread(new JoiningClass(51, 75, run2));
    Thread run4 = new Thread(new JoiningClass(76, 100, run3));

    run1.start();
    run2.start();
    run3.start();
    run4.start();
  }
}
