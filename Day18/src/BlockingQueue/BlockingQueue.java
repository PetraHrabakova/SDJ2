package BlockingQueue;

import utility.collection.BoundedArrayQueue;
import utility.collection.QueueADT;

public class BlockingQueue<T> implements Buffer<T>
{
  private QueueADT<T> queue;

  public BlockingQueue(int capacity) {
    queue = new BoundedArrayQueue<T>(capacity);
  }

  @Override public synchronized void put(T element)
  {
    while (isFull())
    try {
      wait();
  }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    queue.enqueue(element);
    notifyAll();
    System.out.println("Put: " + element);
  }

  @Override public synchronized T take()
  {
    while (isEmpty())
      try {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      notifyAll();
      System.out.println("Took element away");
      return queue.dequeue();
  }

  @Override public synchronized T look()
  {
    if (queue.isEmpty()) {
      System.out.println("Done looking, the queue is empty");
      return null;
    }
    else {
      System.out.println("Done, looking");
      return queue.first();
    }
  }

  @Override public synchronized boolean isEmpty()
  {
    return queue.isEmpty();
  }

  @Override public synchronized boolean isFull()
  {
    return queue.isFull();
  }

  @Override public synchronized int size()
  {
    return queue.size();
  }

  public synchronized String toString() {
    return "Size of queue: " + size();
  }
}
