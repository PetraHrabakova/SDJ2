package ToUppercaseSockets.client;

import javafx.application.Application;
import javafx.stage.Stage;
import ToUppercaseSockets.client.core.ClientFactory;
import ToUppercaseSockets.client.core.ModelFactory;
import ToUppercaseSockets.client.core.ViewHandler;
import ToUppercaseSockets.client.core.ViewModelFactory;

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
