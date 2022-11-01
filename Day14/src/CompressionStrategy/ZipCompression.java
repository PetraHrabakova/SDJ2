package CompressionStrategy;

public class ZipCompression implements CompressionMethod
{
  @Override
  public String compress(String filename)
  {
    System.out.println("Compressing file...");
    return filename + ".zip";
  }
}
