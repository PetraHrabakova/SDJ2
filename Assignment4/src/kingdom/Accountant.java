package kingdom;

import log.Log;

public class Accountant implements Runnable {
  private Guardsman guardsman;

  public Accountant(Guardsman guardsman) {
    this.guardsman = guardsman;
  }

  @Override public void run() {
    while (true) {
      countValuables();
      restAfterCounting();
    }
  }

  public void countValuables() {
    try {
      guardsman.getAccessToSeeTheTreasureRoom(this);
      Thread.sleep(2000);
      Log.getInstance().addLog("Accountant counted " + guardsman.getAmountOfTreasures() + " valuables in THE TREASURE ROOM");
      guardsman.releaseAccessToSeeTheTreasureRoom(this);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void restAfterCounting() {
    try {
      Log.getInstance().addLog("Accountant is resting after counting valuables");
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
