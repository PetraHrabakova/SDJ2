package valuables;

import java.util.HashMap;
import java.util.Map;

public class ValuablesMultiton
{
  private static Map<String, ValuablesMultiton> map = new HashMap<>();
  private String name;

  private ValuablesMultiton(String name) {
    this.name = name;
  }

  public static ValuablesMultiton getInstance(String key)
  {
    ValuablesMultiton instance = map.get(key);
    if (instance == null) {
      synchronized (map)
      {
        instance = map.get(key);
        if (instance == null)
        {
          instance = new ValuablesMultiton(key);
          map.put(key, instance);
        }
      }
    }
    return instance;
  }

  public String getName() {
    return name;
  }
}
