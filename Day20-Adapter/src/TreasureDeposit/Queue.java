package TreasureDeposit;

import java.util.ArrayList;

public class Queue implements BlockingQueueForTreasures
{
  private ArrayList<Valuable> arrayList;

  public Queue() {
    arrayList = new ArrayList<>();
  }

  @Override public void enqueue(Valuable valuable) {
    if (valuable == null) {
      throw new IllegalStateException();
    }
    else
    {
      arrayList.add(valuable);
      System.out.println("Deposited: " + valuable);
    }
  }

  @Override public Valuable dequeue()
  {
    if (arrayList.size() == 0) {
      throw new IllegalStateException();
    }
    else
      return arrayList.remove(0);
  }

  @Override public Valuable first()
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

  @Override public int indexOf(Valuable valuable)
  {
    return arrayList.indexOf(valuable);
  }

  @Override public boolean contains(Valuable valuable)
  {
    return arrayList.contains(valuable);
  }

  public String toString() {
    return "";
  }
}
