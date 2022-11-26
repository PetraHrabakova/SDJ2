package CookieJar;

public class CookieEater implements Runnable
{
  CookieJar<Cookie> cookieJar;

  public CookieEater(CookieJar cookieJar) {
    this.cookieJar = cookieJar;
  }

  @Override public void run()
  {
    while (true) {
      try {
        Thread.sleep(2000);
        cookieJar.take();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      System.out.println("Ate a cookie");
      System.out.println("Cookies in a cookie jar: " + cookieJar.size());
    }
  }

}
