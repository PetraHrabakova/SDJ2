package TimestampWithObserver;

import javafx.application.Application;
import javafx.stage.Stage;
import TimestampWithObserver.model.DataModelManager;
import TimestampWithObserver.model.ModelFactory;
import TimestampWithObserver.view.ViewHandler;
import TimestampWithObserver.viewmodel.ViewModelFactory;

import java.util.Random;

//import client.model.ModelFactory;
//import client.viewmodel.ViewModelFactory;

@SuppressWarnings("ALL")
public class TimestampObserverApp extends Application {

  @Override
  public void start(Stage stage) throws Exception {
    //        DataModel client.model = new DataModelManager();
    //        TimestampViewModel viewModel =new TimestampViewModel(client.model);
    //        ViewHandler viewHandler = new ViewHandler(stage, viewModel);
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
