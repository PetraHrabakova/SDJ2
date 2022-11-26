package TreasureDeposit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Valuable
{
  private static Map<String, Valuable> map = new HashMap<>();
  private ArrayList<ValuablesLine> al;

  private Valuable() {
    al = new ArrayList<>();
  }

  public void addValuable(String valuable)
  {
    ValuablesLine newValuableLine = new ValuablesLine(valuable);
    al.add(newValuableLine);
    System.out.println("Added valuable: " + newValuableLine);
  }

  public static Valuable getInstance(String key)
  {
    Valuable instance = map.get(key);
    if (instance == null)
    {
      synchronized (map)
      {
        instance = map.get(key);
        if (instance == null)
        {
          instance = new Valuable();
          map.put(key, instance);
        }
      }
    }
    return instance;
  }


  public String toString() {
    String str = "";
    for (ValuablesLine valuablesLine : al)
    {
      str += valuablesLine + "\n";
    }
    return str;
  }


}
