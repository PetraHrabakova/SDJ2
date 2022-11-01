package HeaterSystem.view;

import HeaterSystem.viewmodel.HeaterSystemViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ThermometerViewController
{
  private HeaterSystemViewModel viewModel;
  private ViewHandler viewHandler;
  @FXML TextField temperature1;
  @FXML TextField temperature2;
  @FXML TextField temperature3;
  @FXML TextField criticalState;

  public void init(HeaterSystemViewModel viewModel, ViewHandler viewHandler)
  {
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;

    temperature1.textProperty().bind(viewModel.getTemperature1());
    temperature2.textProperty().bind(viewModel.getTemperature2());
    temperature3.textProperty().bind(viewModel.getTemperature3());
    criticalState.textProperty().bind(viewModel.isCritical());

  }

  public void goToHeaterView(ActionEvent actionEvent) {
    try {
      viewHandler.openView("Heater");
    } catch (IOException e) {
      System.out.println("Throws IO exception");
    }
  }
}
