package ChatSystemMVVMSockets.client.views.chatwindow;

import ChatSystemMVVMSockets.client.model.DataModelManager;
import ChatSystemMVVMSockets.client.viewmodel.ChatWindowViewModel;
import ChatSystemMVVMSockets.client.viewmodel.ViewModelFactory;
import ChatSystemMVVMSockets.client.views.ViewController;
import ChatSystemMVVMSockets.client.views.ViewHandler;
import ChatSystemMVVMSockets.shared.transferobjects.MessageEntry;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ChatWindowController implements ViewController
{
  private ChatWindowViewModel viewModel;
  private ViewHandler viewHandler;
  @FXML ListView<MessageEntry> chatWindow;
  @FXML TextField message;


  public void init(ViewHandler viewHandler, ViewModelFactory vmf) {
    this.viewHandler = viewHandler;
    this.viewModel = vmf.getChatWindowViewModel();
    viewModel.loadMessages();
    chatWindow.setItems(viewModel.getMessages());
    message.textProperty().bindBidirectional(viewModel.messageProperty());
  }

  @FXML
  private void sendMessage(ActionEvent actionEvent) {
    viewModel.addMessage();
    //viewModel.loadMessages();
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
