package BoundedQueue;

import java.util.ArrayList;

public class Queue implements StringQueue
{
  private int capacity;
  private ArrayList<String> arrayList;

  public Queue(int capacity) {
    this.capacity = capacity;
    arrayList = new ArrayList<>(capacity);
  }

  @Override public void enqueue(String element) {
    if (element == null) {
      throw new IllegalStateException();
    }
    else if (capacity == arrayList.size()) {
      throw new IllegalStateException();
    }
    else
    {
      arrayList.add(element);
      System.out.println("Put: " + element);
    }
  }

  @Override public String dequeue()
  {
    if (arrayList.size() == 0) {
      throw new IllegalStateException();
    }
    else
      return arrayList.remove(0);
  }

  @Override public String first()
  {
    if (arrayList.isEmpty()) {
      throw new IllegalStateException();
    }
    else
      return arrayList.get(0);
  }

  @Override public int size()
  {
    return arrayList.size();
  }

  @Override public boolean isEmpty()
  {
    return arrayList.size() == 0;
  }

  @Override public int indexOf(String element)
  {
    return arrayList.indexOf(element);
  }

  @Override public boolean contains(String element)
  {
    return arrayList.contains(element);
  }

  public String toString() {
    return "";
  }
}
