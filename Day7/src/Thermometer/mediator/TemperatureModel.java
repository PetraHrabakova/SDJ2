package Thermometer.mediator;

import Thermometer.model.Temperature;

public interface TemperatureModel extends NamedPropertyChangeSubject
{
  void addTemperature(String id, double temperature);

  Temperature getLastInsertedTemperature();

  Temperature getLastInsertedTemperature(String id);
}
