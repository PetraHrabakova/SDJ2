package SimpleMVVM.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import SimpleMVVM.viewmodel.TimestampViewModel;
//import client.viewmodel.ViewModelFactory;

public class TimestampController {

    @FXML
    Label eventLabel;

    @FXML
    Label numberOfUpdates;


    private TimestampViewModel viewModel;

    public TimestampController() {
    }

    public void init(TimestampViewModel viewModel) {
        this.viewModel = viewModel;

        eventLabel.textProperty().bind(viewModel.updateTimeStampProperty());
        try {
            numberOfUpdates.textProperty().bind(viewModel.updateNumberOfUpdates());
        }
        catch (NullPointerException e) {
            System.out.println("Null pointer bitch");
        }

    }

    public void onUpdateButton(ActionEvent actionEvent) {
        viewModel.updateTimestamp();
        viewModel.updateNumberOfUpdates();
    }
}
