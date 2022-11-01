package LogSingleton;

public class TestLog
{
  public static void main(String[] args)
  {
    Log.getInstance().addLog("this is log1");
    Log.getInstance().addLog("this is log2");

    System.out.println(Log.getInstance().getAll());

  }
}
