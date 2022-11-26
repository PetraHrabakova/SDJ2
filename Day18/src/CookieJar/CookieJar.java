package CookieJar;

import utility.collection.BoundedArrayQueue;
import utility.collection.QueueADT;

public class CookieJar<Cookie> implements Buffer<Cookie>
{
  private QueueADT<Cookie> queue;
  private int capacity;
  private int limitToStartBaking;

  public CookieJar(int capacity, int limitToStartBaking) {
    queue = new BoundedArrayQueue<>(capacity);
    this.capacity = capacity;
    this.limitToStartBaking = limitToStartBaking;
  }

  @Override public synchronized void put(Cookie cookie) {
    while (isFull())
      try {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    queue.enqueue(cookie);
    notifyAll();
  }

  @Override public synchronized Cookie take() {
    while (isEmpty())
      try {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    notifyAll();
    return queue.dequeue();
  }

  @Override public synchronized Cookie look() {
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
    return "";
  }

  public int limitToStartBaking() {
    return limitToStartBaking;
  }
}
