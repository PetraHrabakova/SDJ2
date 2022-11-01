package CompressionStrategy;

import java.util.ArrayList;
import java.util.List;

public class CompressorTest
{
  public static void main(String[] args)
  {
    List<String> files = new ArrayList<>() {{ add("file1"); add("file2"); }};

    CompressionMethod method1 = new ZipCompression();
    CompressionMethod method2 = new SevenCCompression();
    Compressor newCompressor = new Compressor();

    newCompressor.setCompressionMethod(method1);
    newCompressor.compress(files);

    newCompressor.setCompressionMethod(method2);
    newCompressor.compress(files);

  }
}
