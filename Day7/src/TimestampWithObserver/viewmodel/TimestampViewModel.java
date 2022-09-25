package TimestampWithObserver.viewmodel;

import javafx.application.Platform;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import TimestampWithObserver.model.DataModel;
import TimestampWithObserver.model.PropertyChangeSubject;
import javafx.scene.paint.Paint;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;

public class TimestampViewModel {

    private StringProperty updateTimeStamp;

    private StringProperty numberOfUpdates;

    private DataModel model;

    private Property<Paint> paintProperty;

    public TimestampViewModel(DataModel model) {
        this.model = model;
        updateTimeStamp = new SimpleStringProperty("Last update: ");
        numberOfUpdates = new SimpleStringProperty("0");
        paintProperty = new SimpleObjectProperty<>();
        ((PropertyChangeSubject) model).addPropertyChangeListener((PropertyChangeEvent evt) -> this.propertyChange(evt));
    }

    public void propertyChange(PropertyChangeEvent event) {
        Platform.runLater(() -> {
            if (String.valueOf(event.getPropertyName()).equals("Updated")){
                updateTimeStamp.setValue("Last updated: " + model.getLastUpdateTimeStamp());
                numberOfUpdates.setValue("Number of updates:" + model.getNumberOfUpdates());
            }
            if (event.getNewValue().equals(Paint.valueOf("Green"))){
                paintProperty.setValue(Paint.valueOf("Green"));

            }
            if (event.getNewValue().equals(Paint.valueOf("Red"))){
                paintProperty.setValue(Paint.valueOf("Red"));

            }
        });
    }

    public Property<Paint> changeColor(){
        paintProperty.setValue(Paint.valueOf("white"));
        return paintProperty;
    }


    public StringProperty updateTimeStampProperty() {
        return updateTimeStamp;
    }

    public StringProperty numberOfUpdatesProperty() {
        return numberOfUpdates;
    }

    public void increaseNumber(){
        model.increaseNumberOfUpdates();
    }
}
