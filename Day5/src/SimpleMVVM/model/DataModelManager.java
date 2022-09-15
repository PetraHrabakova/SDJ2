package SimpleMVVM.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DataModelManager implements DataModel {

    private int numberOfUpdates;

    private String lastUpdate;

    public DataModelManager() {
        System.out.println("New DataModel");
    }

    @Override
    public String getLastUpdateTimeStamp() {
        return lastUpdate;
    }

    public void recalculateData() {
        calcTimeStamp();
    }

    public void increaseNumberOfUpdates() {
        numberOfUpdates++;
    }

    public int getNumberOfUpdates() {
        return numberOfUpdates;
    }

    private void calcTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm:ss");
        Date now = new Date();
        String strDate = sdfDate.format(now);
        System.out.println(strDate);
        lastUpdate = strDate;
    }
}
