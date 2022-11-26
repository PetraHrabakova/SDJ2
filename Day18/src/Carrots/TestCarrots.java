package Carrots;

public class TestCarrots
{
  public static void main(String[] args)
  {
    BlockingQueue<String> queue = new BlockingQueue<String>();

    Peeler peeler = new Peeler(queue);
    Eater eater = new Eater(queue);
    new Thread(peeler).start();
    new Thread(eater).start();

  }
}
