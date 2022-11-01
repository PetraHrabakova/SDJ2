package ChatSystemMVVMLocal.views.login;

import ChatSystemMVVMLocal.viewmodel.LoginViewModel;
import ChatSystemMVVMLocal.views.ViewHandler;
import ChatSystemMVVMLocal.viewmodel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ChatSystemMVVMLocal.views.ViewController;

public class LoginViewController implements ViewController {
    @FXML
    private Label errorLabel;
    @FXML
    private TextField usernameField;
    private LoginViewModel viewModel;
    private ViewHandler vh;

    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        this.viewModel = vmf.getLoginViewModel();
        errorLabel.textProperty().bind(viewModel.errorProperty());
        usernameField.textProperty().bindBidirectional(viewModel.usernameProperty());
    }

    @FXML
    private void onSubmitButton() {
        viewModel.addUser();
    }

    @FXML
    private void onlineUsersButton() {
        vh.openOnlineUsers();
    }

    @FXML
    private void enterChat() { vh.openChatWindow(); }
}

