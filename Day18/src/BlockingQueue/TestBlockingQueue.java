package BlockingQueue;

import utility.collection.BoundedArrayQueue;

public class TestBlockingQueue
{
  public static void main(String[] args)
  {
    BlockingQueue<String> queue = new BlockingQueue<String>(10);

    ThreadThatPuts t1 = new ThreadThatPuts(queue);
    ThreadThatTakes t2 = new ThreadThatTakes(queue);
    new Thread(t1).start();
    new Thread(t2).start();

  }
}
