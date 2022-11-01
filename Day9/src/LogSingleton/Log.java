package LogSingleton;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class Log
{
  private ArrayList<LogLine> al;
  private static Log instance;
  private static Object lock = new Object();
  
  private Log()
  {
    al = new ArrayList<>();
  }

  public void addLog(String log)
  {
    LogLine newLogLine = new LogLine(log);
    al.add(newLogLine);
    addtoFile(newLogLine);
    System.out.println(newLogLine);
  }

  public ArrayList<LogLine> getAll()
  {
    return al;
  }

  public String toString()
  {
    String str = "";
    for (LogLine log : al)
    {
      str += log + "\n";
    }
    return str;
  }

  private void addtoFile(LogLine log)
  {
    if (log == null)
    {
      return;
    }
    BufferedWriter out = null;
    try
    {
      String filename = "Log-" + log.getDateTime().getSortableDate() + ".txt";
      out = new BufferedWriter(new FileWriter(filename, true));
      out.write(log + "\n");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      try
      {
        out.close();
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
  }
  
  public static Log getInstance()
  {
    if (instance == null)
    {
      synchronized (lock)
      {
        if (instance == null)
        {
          instance = new Log();
        }
      }
    }
    return instance;
  }

}
