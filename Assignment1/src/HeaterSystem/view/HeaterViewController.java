package HeaterSystem.view;

import HeaterSystem.viewmodel.HeaterSystemViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class HeaterViewController
{
    @FXML TextField heaterState;

    private HeaterSystemViewModel viewModel;
    private ViewHandler viewHandler;


    public void init(HeaterSystemViewModel viewModel, ViewHandler viewHandler) {
        this.viewModel = viewModel;
        this.viewHandler = viewHandler;

        heaterState.textProperty().bind(viewModel.getPower());
    }

    public void turnUp(ActionEvent actionEvent) {
        viewModel.turnUp();
    }

    public void turnDown(ActionEvent actionEvent) {
        viewModel.turnDown();
    }


    public void goToThermometerView(ActionEvent actionEvent) {
        try {
            viewHandler.openView("Thermometer");
        } catch (IOException e) {
            System.out.println("Throws OI exception");
        }
    }
}
