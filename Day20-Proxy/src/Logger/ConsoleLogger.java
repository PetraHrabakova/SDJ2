package Logger;

public class ConsoleLogger implements Logger
{
  private LogLevelController logLevelController;

  public ConsoleLogger(String level) {
    logLevelController = new LogLevelController(level);
  }
  @Override public void log(String text) {
    logLevelController.log(text);
  }
}
