package ChatSystemMVVMSockets.client;

import ChatSystemMVVMSockets.client.model.ClientFactory;
import ChatSystemMVVMSockets.client.model.ModelFactory;
import ChatSystemMVVMSockets.client.viewmodel.ViewModelFactory;
import ChatSystemMVVMSockets.client.views.ViewHandler;
import javafx.application.Application;
import javafx.stage.Stage;

public class ChatApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ClientFactory cf = new ClientFactory();
        ModelFactory mf = new ModelFactory(cf);
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler vh = new ViewHandler(vmf);
        vh.start();
    }
}
