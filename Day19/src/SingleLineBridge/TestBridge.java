package SingleLineBridge;

public class TestBridge
{
  public static void main(String[] args)
  {
    Bridge bridge = new Bridge();

    Car car1 = new Car(bridge, 2000, 5000, "left");
    Car car2 = new Car(bridge, 1500, 10000, "right");
    Car car3 = new Car(bridge, 2000, 7000, "left");
    Car car4 = new Car(bridge, 1000, 3000, "right");


    new Thread(car1).start();
    new Thread(car2).start();
    new Thread(car3).start();
    new Thread(car4).start();
  }
}
