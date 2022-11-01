package ChatSystemMVVMSockets.server.network;

import ChatSystemMVVMSockets.server.model.DataModel;
import ChatSystemMVVMSockets.shared.transferobjects.MessageEntry;
import ChatSystemMVVMSockets.shared.transferobjects.Request;
import ChatSystemMVVMSockets.shared.transferobjects.UserEntry;

import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class SocketHandler implements Runnable
{
  private Socket socket;
  private DataModel model;

  private ObjectOutputStream outToClient;
  private ObjectInputStream inFromClient;

  public SocketHandler(Socket socket, DataModel model) {
    this.socket = socket;
    this.model = model;

    try {
      outToClient = new ObjectOutputStream(socket.getOutputStream());
      inFromClient = new ObjectInputStream(socket.getInputStream());
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override public void run()
  {
    try {
      Request request = (Request) inFromClient.readObject();
      if ("Listener".equals(request.getType())) {
        model.addListener("NewUserEntry", this::onNewUserEntry);
        model.addListener("NewMessageEntry", this::onNewMessageEntry);
      }
      else if ("AddUser".equals(request.getType())) {
        model.addUser((UserEntry)request.getArg());
      }
      else if ("GetUsers".equals(request.getType())) {
        List<UserEntry> users = model.getUsers();
        outToClient.writeObject(new Request("GetUsers", users));
      }
      else if ("AddMessage".equals(request.getType())) {
        model.addMessage((MessageEntry) request.getArg());
      }
      else if ("GetMessages".equals(request.getType())) {
        List<MessageEntry> messages = model.getMessages();
        outToClient.writeObject(new Request("GetMessages", messages));
      }
    }
    catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }

  }

  private void onNewUserEntry(PropertyChangeEvent event) {
    try {
      outToClient.writeObject(new Request(event.getPropertyName(), event.getNewValue()));
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void onNewMessageEntry(PropertyChangeEvent event) {
    try {
      outToClient.writeObject(new Request(event.getPropertyName(), event.getNewValue()));
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

}
