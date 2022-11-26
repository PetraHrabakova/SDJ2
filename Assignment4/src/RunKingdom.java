import kingdom.Accountant;
import kingdom.King;
import kingdom.Guardsman;
import valuables.BlockingQueueForDeposit;
import valuables.MinerProducer;
import valuables.ValuablesMultiton;
import valuables.TransporterConsumer;

public class RunKingdom
{
  public static void main(String[] args)
  {
    BlockingQueueForDeposit<ValuablesMultiton> blockingQueueForDeposit = new BlockingQueueForDeposit<ValuablesMultiton>(100);
    Guardsman guardsman = new Guardsman();

    new Thread(new MinerProducer(blockingQueueForDeposit), "Miner-1").start();
    new Thread(new MinerProducer(blockingQueueForDeposit), "Miner-2").start();
    new Thread(new TransporterConsumer(blockingQueueForDeposit, guardsman), "ValuablesTransporter-1").start();
    new Thread(new Accountant(guardsman), "Accountant-1").start();
    new Thread(new King(guardsman), "The King").start();
  }
}
