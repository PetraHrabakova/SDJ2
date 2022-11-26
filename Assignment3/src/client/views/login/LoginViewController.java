package client.views.login;

import client.viewmodel.LoginViewModel;
import client.viewmodel.ViewModelFactory;
import client.views.ViewController;
import client.views.ViewHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginViewController implements ViewController
{
  @FXML private Label errorLabel;
  @FXML private TextField usernameField;
  private LoginViewModel viewModel;
  private ViewHandler vh;

  public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.vh = vh;
    this.viewModel = vmf.getLoginViewModel();
    errorLabel.textProperty().bindBidirectional(viewModel.errorProperty());
    usernameField.textProperty().bindBidirectional(viewModel.usernameProperty());
  }

  @FXML private void onSubmitButton()
  {
    viewModel.addUser();
  }

  @FXML private void onlineUsersButton()
  {
    vh.openOnlineUsers();
  }

  @FXML private void enterChat()
  {
    if (usernameField.getText() == null)
    {
      errorLabel.setText("Please input a username");
    }
    else
      vh.openChatWindow();
  }
}

