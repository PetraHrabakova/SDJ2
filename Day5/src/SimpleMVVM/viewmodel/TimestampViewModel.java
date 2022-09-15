package SimpleMVVM.viewmodel;

import SimpleMVVM.model.DataModel;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TimestampViewModel {

    private StringProperty updateTimeStamp;
    private StringProperty numberOfUpdates;


    private DataModel model;

    public TimestampViewModel(DataModel model) {
        this.model = model;
        updateTimeStamp = new SimpleStringProperty("Last update: ");
        numberOfUpdates = new SimpleStringProperty("Number of updates: ");
    }

    public void updateTimestamp() {
        updateTimeStamp.setValue("Last updated: " + model.getLastUpdateTimeStamp());
    }

    public StringProperty updateTimeStampProperty() {
        return updateTimeStamp;
    }

    public StringProperty updateNumberOfUpdates() {
        model.increaseNumberOfUpdates();
        numberOfUpdates.setValue("Number of updates: " + model.getNumberOfUpdates());
        return numberOfUpdates;
    }
}
