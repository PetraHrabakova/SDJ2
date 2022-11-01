package HeaterSystem.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class DataModelManager implements DataModel, PropertyChangeSubject {
    private final Heater heater;

    private double temperatureByHeater = 22;
    private double temperatureIndoor = 19;
    private double temperatureOutdoor = 10;

    private double oldTemperatureByHeater = 21;
    private double oldTemperatureIndoor = 18;
    private double oldTemperatureOutdoor = 9;

    private String criticalState = "OK";

    private static final double HIGH_INDOOR = 30;
    private static final double LOW_INDOOR = 8;
    private static final double HIGH_OUTDOOR = 40;
    private static final double LOW_OUTDOOR = -15;

    private PropertyChangeSupport propertyChangeSupport;


    public DataModelManager(Heater heater) {
        this.heater = heater;

        Thread thermometerByHeater = new Thread(new Thermometer(this, "ByHeater", temperatureByHeater, temperatureOutdoor, 1, false));
        Thread thermometerIndoor = new Thread(new Thermometer(this, "Indoor", temperatureIndoor, temperatureOutdoor, 7, false));
        Thread thermometerOutdoor = new Thread(new Thermometer(this, "Outdoor", temperatureIndoor, temperatureOutdoor, 20, true));

        thermometerOutdoor.start();
        thermometerByHeater.start();
        thermometerIndoor.start();

        propertyChangeSupport = new PropertyChangeSupport(this);

    }


    @Override public double getTemperatureByHeater() {
        return temperatureByHeater;
    }

    @Override public double getTemperatureIndoor() {

        return temperatureIndoor;
    }

    @Override public double getTemperatureOutdoor() {
        return temperatureOutdoor;
    }

    @Override public void setTemperatureByHeater(double temperatureByHeater) {
        this.temperatureByHeater = temperatureByHeater;
    }

    @Override public void setTemperatureIndoor(double temperatureIndoor) {
        this.temperatureIndoor = temperatureIndoor;
    }

    @Override public void setTemperatureOutdoor(double temperatureOutdoor) {
        this.temperatureOutdoor = temperatureOutdoor;
    }

    public void changeTemperatures() {

        if (temperatureByHeater != oldTemperatureByHeater || temperatureIndoor != oldTemperatureIndoor ||
        temperatureOutdoor != oldTemperatureOutdoor) {

            propertyChangeSupport.firePropertyChange("NewTemperatureOutside", 0, temperatureOutdoor);
            propertyChangeSupport.firePropertyChange("NewTemperatureIndoor", 0, temperatureIndoor);
            propertyChangeSupport.firePropertyChange("NewTemperatureByHeater", 0, temperatureByHeater);

            oldTemperatureByHeater = temperatureByHeater;
            oldTemperatureIndoor = temperatureIndoor;
            oldTemperatureOutdoor = temperatureOutdoor;
        }

        if (temperatureOutdoor <= LOW_OUTDOOR || temperatureIndoor <= LOW_INDOOR ||
            temperatureByHeater <= LOW_INDOOR) {
            criticalState = "LOW";
            propertyChangeSupport.firePropertyChange("UpdatedCriticalState", null, "LOW");


        }
        else if (temperatureOutdoor >= HIGH_OUTDOOR || temperatureIndoor >= HIGH_INDOOR ||
            temperatureByHeater >= HIGH_INDOOR) {
            criticalState = "HIGH";
            propertyChangeSupport.firePropertyChange("UpdatedCriticalState", null, "HIGH");
        }
        else {
            propertyChangeSupport.firePropertyChange("UpdatedCriticalState", null, "OK");
            criticalState = "OK";
        }



    }

    @Override public void turnUp() { heater.turnUp(); }

    @Override public void turnDown()
    {
        heater.turnDown();
    }

    @Override public String getPower() { return heater.getPower(); }

    @Override public String isCritical() { return criticalState; }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    @Override public void removePropertyChangeListener(PropertyChangeListener listener) { }
}
