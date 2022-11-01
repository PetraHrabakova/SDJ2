package HeaterSystem;

import HeaterSystem.model.DataModelManager;
import HeaterSystem.model.ModelFactory;
import HeaterSystem.view.ViewHandler;
import HeaterSystem.viewmodel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Random;


@SuppressWarnings("ALL")
public class HeaterObserverApp extends Application {

  @Override
  public void start(Stage stage) throws Exception {
    ModelFactory mf = new ModelFactory();
    ViewModelFactory viewModelFactory = new ViewModelFactory(mf);
    ViewHandler viewHandler = new ViewHandler(stage, viewModelFactory);
    viewHandler.start();
    runAutoUpdate((DataModelManager) mf.getDataModel());
  }

  private void runAutoUpdate(DataModelManager m)
  {
    Thread thread = new Thread(() -> {
      Random r = new Random();
      while (true)
      {
        m.changeTemperatures();

        try
        {
          Thread.sleep(r.nextInt(3000) + 1000);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }
    });

    thread.setDaemon(true);
    thread.start();

  }
}
