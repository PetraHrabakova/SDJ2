package HeaterSystem.model;

public interface HeaterState
{
  void turnUp(Heater heater);

  void turnDown(Heater heater);

  String getPower();

}
