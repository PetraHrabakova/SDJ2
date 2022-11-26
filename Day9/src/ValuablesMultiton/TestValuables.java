package ValuablesMultiton;

public class TestValuables
{
  public static void main(String[] args)
  {
    Valuable.getInstance("Diamond").addValuable("Diamond");
    Valuable.getInstance("Gold nugget").addValuable("Gold nugget");
    Valuable.getInstance("Jewel").addValuable("Jewel");
    Valuable.getInstance("Ruby").addValuable("Ruby");

    System.out.println(Valuable.getInstance("Diamond"));
    System.out.println(Valuable.getInstance("Gold nugget"));


    ;
  }
}
