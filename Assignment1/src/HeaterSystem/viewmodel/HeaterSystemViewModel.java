package HeaterSystem.viewmodel;

import HeaterSystem.model.DataModel;
import javafx.application.Platform;
import javafx.beans.property.*;

import java.beans.PropertyChangeEvent;
import java.text.DecimalFormat;

public class HeaterSystemViewModel
{
    private StringProperty heaterState;
    private StringProperty temperature1Property;
    private StringProperty temperature2Property;
    private StringProperty temperature3Property;
    private StringProperty criticalState;
    private DataModel model;

    public HeaterSystemViewModel(DataModel model) {
        this.model = model;

        heaterState = new SimpleStringProperty("Off");
        temperature1Property = new SimpleStringProperty();
        temperature2Property = new SimpleStringProperty();
        temperature3Property = new SimpleStringProperty();
        criticalState = new SimpleStringProperty();

        model.addPropertyChangeListener(this::propertyChange);
    }

    public void turnUp() {
        model.turnUp();
        heaterState.setValue(model.getPower());
    }

    public void turnDown() {
        model.turnDown();
        heaterState.setValue(model.getPower());
    }

    public StringProperty getPower() {
        heaterState.setValue(model.getPower());
        return heaterState;
    }

    public StringProperty getTemperature1() {
        return temperature1Property;
    }

    public StringProperty getTemperature2() {
        return temperature2Property;
    }

    public StringProperty getTemperature3() {
        return temperature3Property;
    }

    public StringProperty isCritical() {
        return criticalState;
    }

    public void propertyChange(PropertyChangeEvent event) {
        Platform.runLater(() -> {
            if (String.valueOf(event.getPropertyName()).equals("NewTemperatureByHeater")){
                temperature1Property.setValue(new DecimalFormat("##.##").format(model.getTemperatureByHeater()));
            }
            if (String.valueOf(event.getPropertyName()).equals("NewTemperatureIndoor")){
                temperature2Property.setValue(new DecimalFormat("##.##").format(model.getTemperatureIndoor()));
            }
            if (String.valueOf(event.getPropertyName()).equals("NewTemperatureOutside")){
                temperature3Property.setValue(new DecimalFormat("##.##").format(model.getTemperatureOutdoor()));
            }
            if (String.valueOf(event.getPropertyName()).equals("UpdatedCriticalState")){
                criticalState.setValue(model.isCritical());
            }
        });
    }

}
