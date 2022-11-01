package ChatSystemMVVMLocal;

import javafx.application.Application;
import javafx.stage.Stage;
import ChatSystemMVVMLocal.model.ModelFactory;
import ChatSystemMVVMLocal.views.ViewHandler;
import ChatSystemMVVMLocal.viewmodel.ViewModelFactory;

public class ChatApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ModelFactory mf = new ModelFactory();
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler vh = new ViewHandler(vmf);
        vh.start();
    }
}
