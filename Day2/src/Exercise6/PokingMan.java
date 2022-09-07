package Exercise6;

public class PokingMan implements Runnable
{
  private Thread bearThread;

  public PokingMan(Thread bearThread) {
    this.bearThread = bearThread;
  }
  @Override
  public void run() {
    System.out.println("Main is walking");
    System.out.println("Man sees a bear. He wishes to poke the bear.");

    bearThread.interrupt();
    System.out.println("RIP");

  }
}
