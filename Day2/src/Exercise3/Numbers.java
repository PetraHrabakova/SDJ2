package Exercise3;

public class Numbers implements Runnable
{
  private int numberOfNumbers;
  public Numbers(int numberOfNumbers) {
    this.numberOfNumbers = numberOfNumbers;
  }

  @Override
  public void run() {
    for (int i = 0; i < numberOfNumbers; i++) {
      System.out.println(i);
    }
  }
}
