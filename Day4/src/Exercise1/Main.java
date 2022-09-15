package Exercise1;

import Exercise0.Counter;
import Exercise0.Incrementer;

public class Main
{
  public static void main(String[] args)
  {
    DoubleCounter c = new DoubleCounter();
    c.incA();
    c.incB();
    c.incA();
    c.incB();
    System.out.println(c.getA());
    System.out.println(c.getB());
  }
}
