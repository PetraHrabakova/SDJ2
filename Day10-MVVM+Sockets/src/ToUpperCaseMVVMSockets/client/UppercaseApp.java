package ToUpperCaseMVVMSockets.client;

import javafx.application.Application;
import javafx.stage.Stage;
import ToUpperCaseMVVMSockets.client.model.ClientFactory;
import ToUpperCaseMVVMSockets.client.model.ModelFactory;
import ToUpperCaseMVVMSockets.client.views.ViewHandler;
import ToUpperCaseMVVMSockets.client.model.ViewModelFactory;

public class UppercaseApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ClientFactory cf = new ClientFactory();
        ModelFactory mf = new ModelFactory(cf);
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler vh = new ViewHandler(vmf);
        vh.start();
    }
}
