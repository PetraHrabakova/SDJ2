package CompressionStrategy;

import java.util.List;

public class Compressor
{
  CompressionMethod compressionMethod;

  public void setCompressionMethod(CompressionMethod compressionMethod) {
    this.compressionMethod = compressionMethod;
  }

  public void compress(List<String> files) {
    String str = "";
    for (String file: files) {
      if (compressionMethod instanceof SevenCCompression) {
        str += compressionMethod.compress(file) + "\n";
      }
      else if (compressionMethod instanceof ZipCompression) {
        str += compressionMethod.compress(file) + "\n";
      }
    }
    System.out.println(str);
  }
}
