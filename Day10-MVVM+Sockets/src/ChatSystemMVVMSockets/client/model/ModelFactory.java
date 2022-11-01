package ChatSystemMVVMSockets.client.model;

public class ModelFactory {

    private final ClientFactory cf;
    private DataModel model;

    public ModelFactory(ClientFactory cf) {
        this.cf = cf;
    }

    public DataModel getDataModel() {
        if(model == null)
            model = new DataModelManager(cf.getClient());
        return model;
    }
}


