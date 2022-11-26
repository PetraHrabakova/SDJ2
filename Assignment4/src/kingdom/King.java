package kingdom;

import log.Log;
import valuables.ValuablesMultiton;

import java.util.ArrayList;
import java.util.Random;

public class King implements Runnable
{
  private Guardsman guardsman;
  private Random r;
  private ArrayList<ValuablesMultiton> pickedUpValuables;

  public King(Guardsman guardsman) {
    this.guardsman = guardsman;
    r = new Random();
    pickedUpValuables = new ArrayList<>();
  }

  @Override public void run() {
    while (true)
    {
      waitABitBeforeRangingIntoTheTreasureRoom();
      int neededForParty = r.nextInt(6) + 5;    // between 5 and 10 valuables needed for the party
      Log.getInstance().addLog("King needs " + neededForParty + " valuables to throw a party");
      guardsman.getAccessToTakeFromTreasureRoom(this);
      while (true)
      {
        if (guardsman.getAmountOfTreasures() < neededForParty)
        {
          Log.getInstance().addLog("!!! KING JUST CANCELLED THE PARTY !!!");
          putValuablesBack(pickedUpValuables);
          break;
        }

        pickedUpValuables.add(guardsman.takeFromTreasureRoom());
        neededForParty -= 1;

        if (neededForParty <= 0) {
          Log.getInstance().addLog("King just acquired the valuables. START MIXING DRINKS!!!");
          carryValuablesAwayAndStartMixingDrinks();
          break;
        }


      }
    }
  }

  public void putValuablesBack(ArrayList<ValuablesMultiton> valuablesToBePutBack) {
    try {
      guardsman.addToTreasureRoom(valuablesToBePutBack);
      Log.getInstance().addLog("KING RETURNED VALUABLES");
      guardsman.releaseAccessToTakeFromTreasureRoom(this);
      pickedUpValuables.clear();
      Thread.sleep(2000);
    } catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }

  public void carryValuablesAwayAndStartMixingDrinks() {
    try {
      Log.getInstance().addLog("KING IS TAKING VALUABLES AND STARTING PARTY");
      guardsman.releaseAccessToTakeFromTreasureRoom(this);
      pickedUpValuables.clear();
      Thread.sleep(2000);
    } catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }

  public void waitABitBeforeRangingIntoTheTreasureRoom() {
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }
}
