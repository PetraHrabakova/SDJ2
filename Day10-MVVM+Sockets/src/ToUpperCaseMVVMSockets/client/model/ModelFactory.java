package ToUpperCaseMVVMSockets.client.model;


import ToUpperCaseMVVMSockets.client.model.ClientFactory;
import ToUpperCaseMVVMSockets.client.model.TextConverter;
import ToUpperCaseMVVMSockets.client.model.TextConverterManager;

public class ModelFactory {

    private final ClientFactory cf;
    private TextConverter textConverter;

    public ModelFactory(ClientFactory cf) {
        this.cf = cf;
    }

    public TextConverter getTextConverter() {
        if(textConverter == null)
            textConverter = new TextConverterManager(cf.getClient());
        return textConverter;
    }
}


