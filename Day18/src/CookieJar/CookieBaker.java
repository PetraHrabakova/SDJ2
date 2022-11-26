package CookieJar;

public class CookieBaker implements Runnable
{
  CookieJar<Cookie> cookieJar;
  private int amountToBake;

  public CookieBaker(CookieJar cookieJar, int amountToBake)
  {
    this.cookieJar = cookieJar;
    this.amountToBake = amountToBake;
  }

  @Override public void run()
  {
    while (true)
    {
      try
      {
        Thread.sleep(2000);
        if (cookieJar.size() < cookieJar.limitToStartBaking()) {
          for (int i = 0; i <= amountToBake; i++)
          {
            Cookie cookie = new Cookie("Chocolate cookie");
            cookieJar.put(cookie);
          }
          System.out.println("Baked new batch of cookies");
          System.out.println("Cookies in a cookie jar: " + cookieJar.size());
        }
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}