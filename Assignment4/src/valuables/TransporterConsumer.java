package valuables;

import kingdom.Guardsman;
import log.Log;

import java.util.ArrayList;
import java.util.Random;

public class TransporterConsumer implements Runnable
{
  private ArrayList<ValuablesMultiton> pickedUpValuables;
  private BlockingQueueForDeposit<ValuablesMultiton> deposit;
  private Random r;
  private Guardsman guardsman;

  public TransporterConsumer(BlockingQueueForDeposit<ValuablesMultiton> deposit, Guardsman guardsman) {
    this.guardsman = guardsman;
    this.deposit = deposit;
    r = new Random();
    pickedUpValuables = new ArrayList<>();
  }

  @Override public void run() {
    while (true) {
      int amountOfRetrievals = r.nextInt(6) + 5; // retrieve treasures between 5 and 10
      Log.getInstance().addLog(Thread.currentThread().getName() + " needs to retrieve " + amountOfRetrievals);
      while (amountOfRetrievals > 0) {
        ValuablesMultiton valuable = deposit.take();
        Log.getInstance().addLog(Thread.currentThread().getName() + " retrieved " + valuable.getName());
        pickedUpValuables.add(valuable);
        amountOfRetrievals-= 1;
      }
      addToTreasureRoom(pickedUpValuables);
      pickedUpValuables.clear();
      restingAfterTransporting();
    }
  }

  public void restingAfterTransporting() {
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void addToTreasureRoom(ArrayList<ValuablesMultiton> pickedUpValuables) {
    try {
      guardsman.getAccessToAddToTreasureRoom(this);
      guardsman.addToTreasureRoom(pickedUpValuables);
      guardsman.releaseAccessToAddToTreasureRoom(this);
      Log.getInstance().addLog(Thread.currentThread().getName() + " just delivered " + pickedUpValuables.size() + " valuables to THE TREASURE ROOM");
      Thread.sleep(3000);
    }
    catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
