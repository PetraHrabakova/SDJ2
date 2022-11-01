package CompressionStrategy;

public class SevenCCompression implements CompressionMethod
{
  @Override
  public String compress(String filename)
  {
    System.out.println("Compressing file...");
    return filename + ".7zip";

  }
}
