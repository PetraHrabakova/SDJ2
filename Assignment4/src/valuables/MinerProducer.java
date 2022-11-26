package valuables;

import log.Log;

public class MinerProducer implements Runnable {
  private BlockingQueueForDeposit<ValuablesMultiton> deposit;

  public MinerProducer(BlockingQueueForDeposit<ValuablesMultiton> deposit) {
    this.deposit = deposit;
  }

  @Override public void run() {
    while(true) {
      int random = (int) Math.floor(Math.random()*5+1); //Random from 1 to 5
      switch (random) {
        case 1:
        {
          ValuablesMultiton goldenNugget = ValuablesMultiton.getInstance("Golden Nugget");
          deposit.put(goldenNugget);
          Log.getInstance().addLog(Thread.currentThread().getName()+" just mined " + goldenNugget.getName());
          break;
        }
        case 2:
        {
          ValuablesMultiton woodenCoin = ValuablesMultiton.getInstance("Wooden Coin");
          deposit.put(woodenCoin);
          Log.getInstance().addLog(Thread.currentThread().getName()+" just mined " + woodenCoin.getName());
          break;
        }
        case 3:
        {
          ValuablesMultiton diamond = ValuablesMultiton.getInstance("Diamond");
          deposit.put(diamond);
          Log.getInstance().addLog(Thread.currentThread().getName()+" just mined " + diamond.getName());
          break;
        }
        case 4:
        {
          ValuablesMultiton ruby = ValuablesMultiton.getInstance("Ruby");
          deposit.put(ruby);
          Log.getInstance().addLog(Thread.currentThread().getName()+" just mined " + ruby.getName());
          break;
        }
        case 5:
        {
          ValuablesMultiton jewel = ValuablesMultiton.getInstance("Jewel");
          Log.getInstance().addLog(Thread.currentThread().getName()+" just mined " + jewel.getName());
          deposit.put(jewel);
          break;
        }
      }
      sleepingAfterHardWork();
    }
  }

  public void sleepingAfterHardWork() {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
