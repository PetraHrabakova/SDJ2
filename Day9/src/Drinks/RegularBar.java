package Drinks;

import java.util.ArrayList;
import java.util.Arrays;

public class RegularBar extends Bar
{
  private ArrayList<String> drinkTypes = new ArrayList<>(Arrays.asList("Carlsberg", "red", "white", "rose"));

  @Override
  protected Drink makeDrink(String drinkName)
  {
    for (String drinkType : drinkTypes)
    {
      if (drinkName.equalsIgnoreCase(drinkTypes.get(0)))
      {
        System.out.println("I am a beer");
        return new Beer(drinkType);
      }
      else if (drinkName.equalsIgnoreCase(drinkTypes.get(1)) || drinkName
          .equalsIgnoreCase(drinkTypes.get(2)) || drinkName
          .equalsIgnoreCase(drinkTypes.get(3)))
      {
        System.out.println("I am a wine");
        return new Wine(drinkName, drinkName);
      }
    }
    System.out.println("We don't have this thing on the menu so here you have a Carlsberg");
    return new Beer(drinkTypes.get(0));
  }


  @Override
  public ArrayList<String> getDrinkTypes()
  {
    return drinkTypes;
  }

}
