package Drinks;

public class Wine extends Drink
{
  public static String RED = "red";
  public static String WHITE = "white";
  public static String ROSE = "rose";
  private String type;

  public Wine(String name, String type)
  {
    super(name, getDescription(type));
  }

  private static String getDescription(String type) {
    if (type.equalsIgnoreCase("red")) {
      return "In glass, slightly chilled";
    }
    else if (type.equalsIgnoreCase("white") || type.equalsIgnoreCase("rose")) {
      return "In glass, cold";
    }
    return "don't know your fucking wine";
  }
}
