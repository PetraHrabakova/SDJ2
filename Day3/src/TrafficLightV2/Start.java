package TrafficLightV2;
import TrafficLightV2.observers.*;
import TrafficLightV2.subject.*;

public class Start {
    public static void main(String[] args) throws InterruptedException {
        TrafficLight light = new TrafficLight();
        Car car1 = new Car(1);
        Car car2 = new Car(2);
        light.addPropertyChangeListener(car1);
        light.addPropertyChangeListener(car2);
        light.start();

    }
}
