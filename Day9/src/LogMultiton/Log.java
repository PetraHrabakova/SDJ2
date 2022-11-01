package LogMultiton;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Log
{
  private static Map<String, Log> map = new HashMap<>();
  private String fileName;
  private ArrayList<LogLine> al;

  private Log()
  {
    al = new ArrayList<>();
    fileName = "FileWithLogsBitches.txt";
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
      out = new BufferedWriter(new FileWriter(fileName, true));
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
  
  public static Log getInstance(String key)
  {
    Log instance = map.get(key);
    if (instance == null)
    {
      synchronized (map)
      {
        instance = map.get(key);
        if (instance == null)
        {
          instance = new Log();
          map.put(key, instance);
        }
      }
    }
    return instance;
  }

}
