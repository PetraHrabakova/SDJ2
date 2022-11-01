package ChatSystemMVVMSockets.client.views;

import ChatSystemMVVMSockets.client.viewmodel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{

  private Scene loginScene;
  private Stage stage;
  private ViewModelFactory vmf;

  public ViewHandler(ViewModelFactory vmf)
  {
    this.vmf = vmf;
  }

  public void start()
  {
    stage = new Stage();
    openLogin();
  }

  public void openLogin()
  {
    try
    {
      Parent root = loadFXML("../views/login/Login.fxml");

      stage.setTitle("Login");
      loginScene = new Scene(root);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }

    stage.setScene(loginScene);
    stage.show();
  }

  public void openOnlineUsers()
  {
    try
    {
      Parent root = loadFXML("../views/userlist/Userlist.fxml");

      Scene userlistScene = new Scene(root);
      stage.setTitle("Online Users");
      stage.setScene(userlistScene);
      stage.show();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public void openChatWindow()
  {
    try
    {
      Parent root = loadFXML("../views/chatwindow/ChatWindow.fxml");

      Scene chatScene = new Scene(root);
      stage.setTitle("Chat Window");
      stage.setScene(chatScene);
      stage.show();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private Parent loadFXML(String path) throws IOException
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource(path));
    Parent root = loader.load();

    ViewController ctrl = loader.getController();
    ctrl.init(this, vmf);
    return root;
  }
}
