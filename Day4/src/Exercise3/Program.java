package Exercise3;

public class Program implements Runnable
{
  private String program;
  private long maxFrequency;
  private String action;
  private int count;
  private static long RUNTIME = 100000;

  public Program(String program, String action, int count) {
    this.program = program;
    this.action = action;
    this.count = count;
  }

  public void run() {
    normalOperation();
  }

  private void normalOperation() {
    while (maxFrequency < RUNTIME) {
      try {
        Thread.sleep(RUNTIME/count);
        System.out.println(program + " wants to " + action);
        maxFrequency+=count;
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}
