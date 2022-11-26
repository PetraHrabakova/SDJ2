package CookieJar;

public class TestCookieJar {
  public static void main(String[] args)
  {
    CookieJar<Cookie> cookieJar = new CookieJar<Cookie>(35, 5);

    CookieBaker cookieBaker = new CookieBaker(cookieJar, 16);
    CookieEater cookieEater1 = new CookieEater(cookieJar);
    CookieEater cookieEater2 = new CookieEater(cookieJar);
    CookieEater cookieEater3 = new CookieEater(cookieJar);

    new Thread(cookieBaker).start();
    new Thread(cookieEater1).start();
    new Thread(cookieEater2).start();
    new Thread(cookieEater3).start();
  }
}
