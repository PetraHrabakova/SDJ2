package BlockingQueue;

public class ThreadThatTakes implements Runnable
{
  private BlockingQueue<String> queue;

  public ThreadThatTakes(BlockingQueue<String> queue) {
    this.queue = queue;
  }

  @Override public void run()
  {
    while (true) {
      try {
        Thread.sleep(2000);
        queue.take();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      System.out.println("Queue size: " + queue.size());
    }
  }
}
