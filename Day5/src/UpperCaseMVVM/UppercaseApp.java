package UpperCaseMVVM;

import javafx.application.Application;
import javafx.stage.Stage;
import UpperCaseMVVM.viewmodel.ModelFactory;
import UpperCaseMVVM.viewmodel.ViewHandler;
import UpperCaseMVVM.viewmodel.ViewModelFactory;

public class UppercaseApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ModelFactory mf = new ModelFactory();
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler vh = new ViewHandler(vmf);
        vh.start();
    }
}
