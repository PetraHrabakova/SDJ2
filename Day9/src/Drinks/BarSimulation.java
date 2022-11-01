package Drinks;

public class BarSimulation
{
  public static void main(String[] args)
  {
    Bar bar = new RegularBar();
    System.out.println(bar.orderDrink("red"));

    bar.orderDrink("blue");

  }

}
