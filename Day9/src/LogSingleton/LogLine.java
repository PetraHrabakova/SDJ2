package LogSingleton;

public class LogLine
{
  private DateTime time;
  private String text;

  public LogLine(String text) {
    this.text = text;
    time = new DateTime();
  }

  public String getText()
  {
    return text;
  }

  public DateTime getDateTime() {
    return time;
  }

  public String toString() {
    return time + " " + text;
  }


}
