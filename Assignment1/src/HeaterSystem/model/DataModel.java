package HeaterSystem.model;

public interface DataModel extends PropertyChangeSubject {

    double getTemperatureByHeater();
    double getTemperatureIndoor();
    double getTemperatureOutdoor();
    void setTemperatureByHeater(double temperatureByHeater);
    void setTemperatureIndoor(double temperatureIndoor);
    void setTemperatureOutdoor(double temperatureOutdoor);
    void turnUp();
    void turnDown();
    String isCritical();
    String getPower();

}
