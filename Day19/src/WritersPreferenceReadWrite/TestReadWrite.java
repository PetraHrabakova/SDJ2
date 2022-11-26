package WritersPreferenceReadWrite;

public class TestReadWrite
{
  public static void main(String[] args)
  {
    WritersPreferenceReadWrite sr = new WritersPreferenceReadWrite();
    Reader reader1 = new Reader(sr,1000);
    Reader reader2 = new Reader(sr,3000);
    Writer writer1 = new Writer(sr,2000);
    Writer writer2 = new Writer(sr,5000);

    new Thread(reader1).start();
    new Thread(reader2).start();
    new Thread(writer1).start();
    new Thread(writer2).start();

  }
}
