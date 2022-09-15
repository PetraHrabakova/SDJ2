package PieChartMVVM;

import PieChartMVVM.model.ModelFactory;
import PieChartMVVM.model.DataModelManager;
import PieChartMVVM.model.DataModel;
import PieChartMVVM.model.ModelFactory;
import PieChartMVVM.view.ViewHandler;
import PieChartMVVM.viewmodel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;
import PieChartMVVM.view.ViewHandler;

import java.util.Random;

@SuppressWarnings("ALL")
public class PieChartApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        ModelFactory mf = new ModelFactory();
        ViewModelFactory viewModelFactory = new ViewModelFactory(mf);
        ViewHandler viewHandler = new ViewHandler(stage, viewModelFactory);
        viewHandler.start();

        runAutoUpdate((DataModelManager) mf.getDataModel());
    }

    private void runAutoUpdate(DataModelManager m) {
        Thread thread = new Thread(() -> {
            Random r = new Random();
            while (true) {
                m.recalculateData();
                try {
                    Thread.sleep(r.nextInt(500) + 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start() ;
    }
}
