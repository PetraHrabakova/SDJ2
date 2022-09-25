package Thermometer.mediator;

import Thermometer.model.Temperature;
import Thermometer.model.TemperatureList;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TemperatureModelManager implements TemperatureModel
{
  private TemperatureList temperatureList;
  private PropertyChangeSupport support;

  public TemperatureModelManager()
  {
    temperatureList = new TemperatureList();
    support = new PropertyChangeSupport(this);
  }

  @Override public void addTemperature(String id, double value)
  {
    Temperature temperature = new Temperature(id, value);
    Temperature old = getLastInsertedTemperature();
    this.temperatureList.addTemperature(temperature);
    if (old != null && old.getValue() != temperature.getValue())
    {
      System.out.println("-->" + temperature + " (from: " + old + ")");
    }
    support.firePropertyChange("TemperatureChange", old, temperature);
  }

  @Override public Temperature getLastInsertedTemperature()
  {
    return temperatureList.getLastTemperature(null);
  }

  @Override public Temperature getLastInsertedTemperature(String id)
  {
    return temperatureList.getLastTemperature(id);
  }

  @Override public void addListener(String propertyName,
      PropertyChangeListener listener)
  {
    if (propertyName == null) // all events
    {
      support.addPropertyChangeListener(listener);
    }
    else // a specific event
    {
      support.addPropertyChangeListener(propertyName, listener);
    }
  }

  @Override public void removeListener(String propertyName,
      PropertyChangeListener listener)
  {

    if (propertyName == null) // all events
    {
      support.removePropertyChangeListener(listener);
    }
    else // a specific event
    {
      support.removePropertyChangeListener(propertyName, listener);
    }
  }

  // and maybe other methods...
}
