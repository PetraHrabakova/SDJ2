package Exercise9;

public class TestClass
{
  public static void main(String[] args)
  {
    Counter rabbitCounter = new Counter();
    Counter turtleCounter = new Counter();
    Thread turtle = new Thread(new Turtle(rabbitCounter));
    Thread rabbit = new Thread(new Rabbit(turtle, rabbitCounter, turtleCounter));
    turtle.start();
    rabbit.start();
  }
}
