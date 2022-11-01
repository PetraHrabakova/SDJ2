package ChatSystemMVVMLocal.views.chatwindow;

import ChatSystemMVVMLocal.viewmodel.ChatWindowViewModel;
import ChatSystemMVVMLocal.viewmodel.ViewModelFactory;
import ChatSystemMVVMLocal.views.ViewController;
import ChatSystemMVVMLocal.views.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ChatWindowController implements ViewController
{
  private ChatWindowViewModel viewModel;
  private ViewHandler viewHandler;
  @FXML ListView<String> chatWindow;
  @FXML TextField message;


  public void init(ViewHandler viewHandler, ViewModelFactory vmf) {
    this.viewHandler = viewHandler;
    this.viewModel = vmf.getChatWindowViewModel();
    viewModel.loadMessages();
    chatWindow.setItems(viewModel.getMessages());
    message.textProperty().bindBidirectional(viewModel.messageProperty());

    //inputColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
  }

  @FXML
  private void sendMessage(ActionEvent actionEvent) {
    viewModel.addMessage();
    viewModel.loadMessages();
    chatWindow.setItems(viewModel.getMessages());
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
