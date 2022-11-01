package ChatSystemMVVMLocal.util;

import java.beans.PropertyChangeListener;

public interface Subject {

    void addListener(PropertyChangeListener listener);
    void removeListener(PropertyChangeListener listener);

}
