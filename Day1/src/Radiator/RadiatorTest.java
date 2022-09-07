package Radiator;

public class RadiatorTest
{
  public static void main(String[] args)
  {
    Radiator radiator = new Radiator();

    System.out.println(radiator.getPower());
    radiator.turnUp();
    System.out.println(radiator.getPower());
    radiator.turnUp();
    System.out.println(radiator.getPower());
    radiator.turnUp();
    System.out.println(radiator.getPower());
    radiator.turnUp();
    System.out.println(radiator.getPower());
    radiator.turnDown();
    System.out.println(radiator.getPower());
  }
}
