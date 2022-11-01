package HeaterSystem.model;

public class ModelFactory {

    private DataModel dataModel;
    private Heater heater = new Heater();

    public DataModel getDataModel() {
        if(dataModel == null) {
            dataModel = new DataModelManager(heater);
        }
        return dataModel;
    }


}
