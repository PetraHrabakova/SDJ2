package TrafficLight.observers;

public class Taxi implements LightObserver
{
  private String previousLight;
  private int id;

  public Taxi(int id) {
    this.id = id;
  }
  @Override
  public void setLight(String currentLight) {
    if("GREEN".equals(currentLight)) {
      System.out.println("Car " + id + " drives");
    } else if("YELLOW".equals(currentLight)) {
      System.out.println("Car " + id + " drives. It does not give a damn about yellow light");
    } else if("RED".equals(currentLight)) {
      System.out.println("Car " + id + " stops");
    }
    previousLight = currentLight;
  }
}
