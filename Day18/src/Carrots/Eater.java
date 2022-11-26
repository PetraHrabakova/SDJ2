package Carrots;

public class Eater implements Runnable
{
  private BlockingQueue<String> queue;

  public Eater(BlockingQueue queue) {
    this.queue = queue;
  }

  @Override public void run() {
    while (true) {
      try {
        Thread.sleep(2000);
        queue.take();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      System.out.println("Ate a carrot");
      System.out.println("Queue size: " + queue.size());
    }
  }
}
