package LogMultiton;

public class TestLog
{
  public static void main(String[] args)
  {
    Log.getInstance("1").addLog("this is log1");
    Log.getInstance("1").addLog("this is log2");

  }
}
