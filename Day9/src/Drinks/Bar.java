package Drinks;

import java.util.ArrayList;

abstract class Bar {
  protected abstract Drink makeDrink(String name);

  public abstract ArrayList<String> getDrinkTypes();

  public Drink orderDrink(String name) {
    return makeDrink(name);
  }
}
