package Carrots;

public class Peeler implements Runnable
{
  private BlockingQueue<String> queue;

  public Peeler(BlockingQueue queue) {
    this.queue = queue;
  }

  @Override public void run() {
    while (true) {
      try {
        Thread.sleep(1000);
        queue.put("Carrot");
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      System.out.println("Peeled a carrot");
      System.out.println("Queue size: " + queue.size());
    }
  }
}
