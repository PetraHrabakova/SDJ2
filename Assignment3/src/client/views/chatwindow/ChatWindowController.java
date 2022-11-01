package client.views.chatwindow;

import client.viewmodel.ChatWindowViewModel;
import client.viewmodel.ViewModelFactory;
import client.views.ViewController;
import client.views.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import shared.transferobjects.MessageEntry;

public class ChatWindowController implements ViewController
{
  private ChatWindowViewModel viewModel;
  private ViewHandler viewHandler;
  @FXML ListView<MessageEntry> chatWindow;
  @FXML TextField message;
  @FXML Label error;


  public void init(ViewHandler viewHandler, ViewModelFactory vmf) {
    this.viewHandler = viewHandler;
    this.viewModel = vmf.getChatWindowViewModel();
    viewModel.loadMessages();
    chatWindow.setItems(viewModel.getMessages());
    message.textProperty().bindBidirectional(viewModel.messageProperty());
    error.textProperty().bind(viewModel.errorProperty());
  }

  @FXML
  private void sendMessage(ActionEvent actionEvent) {
    viewModel.addMessage();
    chatWindow.setItems(viewModel.getMessages());
    message.setText(viewModel.getMessageIdentificator());

  }

  @FXML
  private void onlineUsers(ActionEvent actionEvent) {
    viewHandler.openOnlineUsers();
  }

  @FXML
  private void exit(ActionEvent actionEvent) {
    viewHandler.openLogin();
  }

}
