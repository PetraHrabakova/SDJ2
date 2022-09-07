package TrafficLight;

import TrafficLight.observers.*;
import TrafficLight.subject.TrafficLight;

public class Start {
    public static void main(String[] args) throws InterruptedException {
        TrafficLight light = new TrafficLight();
        LightObserver car1 = new Car(1);
        LightObserver car2 = new SpeedyCar(2);
        LightObserver car3 = new Taxi(3);
        LightObserver car4 = new SleepyDriver(4);
        LightObserver person = new Pedestrian(1);
        light.addObserver(car1);
        light.addObserver(car2);
        light.addObserver(car3);
        light.addObserver(car4);
        light.addObserver(person);

        light.start();

    }
}
