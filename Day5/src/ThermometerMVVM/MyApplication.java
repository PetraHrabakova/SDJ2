package ThermometerMVVM;

import ThermometerMVVM.mediator.TemperatureModel;
import ThermometerMVVM.mediator.TemperatureModelManager;
import ThermometerMVVM.view.ViewHandler;
import javafx.application.Application;
import javafx.stage.Stage;

public class MyApplication extends Application
{
  public void start(Stage primaryStage)
  {
    // Model
    TemperatureModel model = new TemperatureModelManager();

    // View
    ViewHandler view = new ViewHandler(model);
    view.start(primaryStage);
  }
}
