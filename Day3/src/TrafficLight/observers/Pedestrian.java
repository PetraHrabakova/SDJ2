package TrafficLight.observers;

public class Pedestrian implements LightObserver
{
  private String previousLight;
  private int id;

  public Pedestrian(int id) {
    this.id = id;
  }
  @Override
  public void setLight(String currentLight) {
    if("GREEN".equals(currentLight)) {
      System.out.println("Pedestrian is waiting");
    } else if("YELLOW".equals(currentLight)) {
      if ("GREEN".equals(previousLight)) {
        System.out.println("Pedestrian runs over the crosswalk");
      }
      else {
        System.out.println("Pedestrian is probably going to die because the cars are about to drive");
      }
    } else if("RED".equals(currentLight)) {
      System.out.println("Pedestrian crosses the road");
    }
    previousLight = currentLight;
  }
}
