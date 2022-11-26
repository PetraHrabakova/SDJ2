package CookieJar;

public interface Buffer<Cookie>
{
  public void put(Cookie cookie);
  public Cookie take();
  public Cookie look();
  public boolean isEmpty();
  public boolean isFull();
  public int size();
}
