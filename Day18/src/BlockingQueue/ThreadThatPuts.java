package BlockingQueue;

public class ThreadThatPuts implements Runnable
{
  private BlockingQueue<String> queue;

  public ThreadThatPuts(BlockingQueue<String> queue) {
    this.queue = queue;
  }

  @Override public void run()
  {
    while (true) {
      try {
        Thread.sleep(1000);
        queue.put("Hello");
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      System.out.println("Queue size: " + queue.size());
    }
  }
}
