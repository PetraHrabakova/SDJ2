package ThermometerMVVM.mediator;

import ThermometerMVVM.model.Temperature;

public interface TemperatureModel
{
  void addTemperature(String id, double temperature);

  Temperature getLastInsertedTemperature();

  Temperature getLastInsertedTemperature(String id);
}
