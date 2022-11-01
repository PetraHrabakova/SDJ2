package HeaterSystem.view;

import HeaterSystem.model.Heater;
import HeaterSystem.viewmodel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {

    private Stage stage;
    private ViewModelFactory viewModelFactory;
    private Heater heater;

    public ViewHandler(Stage stage, ViewModelFactory viewModelFactory) {
        this.stage = stage;
        this.viewModelFactory = viewModelFactory;
    }

    public void start() throws Exception {
        openView("Heater");
    }

    public void openView(String viewToOpen) throws IOException {
        Scene scene;
        FXMLLoader loader = new FXMLLoader();
        Parent root;

        loader.setLocation(getClass().getResource(viewToOpen + "View.fxml"));
        root = loader.load();
        if ("Heater".equals(viewToOpen)) {
            HeaterViewController view = loader.getController();
            view.init(viewModelFactory.getHeaterViewModel(),this);
            stage.setTitle("Heater System");
        }
        if ("Thermometer".equals(viewToOpen)) {
            ThermometerViewController view = loader.getController();
            view.init(viewModelFactory.getHeaterViewModel(), this);
            stage.setTitle("Thermometer System");
        }
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
