package TimestampWithObserver.model;

import javafx.scene.paint.Paint;

import java.beans.PropertyChangeEvent;

public interface DataModel {

    String getLastUpdateTimeStamp();
    void increaseNumberOfUpdates();
    int getNumberOfUpdates();
    void recalculateData();
    void changeColorPaint();

}
