package shared.util;

import java.beans.PropertyChangeListener;

public interface Subject {

    void addListener(String event, PropertyChangeListener listener);
    void removeListener(String event, PropertyChangeListener listener);

}
