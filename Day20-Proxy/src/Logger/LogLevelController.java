package Logger;

public class LogLevelController implements Logger
{
  private String level;

  public LogLevelController(String level) {
    this.level = level;
  }

  @Override public void log(String text)
  {
    if (level.equals("verbose")) {
      System.out.println("Verbose logger: " + text);
    }
    else if (level.equals("sparse")) {
      if (text.toLowerCase().contains("error")) {
        System.out.println("Sparse logger: " + text);
      }
    }
  }


}
