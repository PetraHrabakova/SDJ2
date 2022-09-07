package Exercise7;

public class PokingMan implements Runnable
{
  private Thread bearThread;

  public PokingMan(Thread bearThread) {
    this.bearThread = bearThread;
  }
  @Override
  public void run() {
    System.out.println("Man is walking");
    System.out.println("Man sees a bear. He wishes to poke the bear.");
    bearThread.interrupt();

    try {
      Thread.sleep(200);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("RIP");

  }
}
