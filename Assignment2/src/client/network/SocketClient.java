package client.network;

import shared.transferobjects.MessageEntry;
import shared.transferobjects.Request;
import shared.transferobjects.UserEntry;
import shared.util.Subject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class SocketClient implements Client
{
  private PropertyChangeSupport support;

  public SocketClient()
  {
    support = new PropertyChangeSupport(this);
  }

  public void startClient()
  {
    try
    {
      Socket socket = new Socket("localhost", 2910);
      ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

      new Thread(() -> listenToServer(outToServer, inFromServer)).start();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private void listenToServer(ObjectOutputStream outToServer, ObjectInputStream inFromServer)
  {
    try {
      outToServer.writeObject(new Request("Listener", null));
      while (true) {
        Request request = (Request) inFromServer.readObject();
        // support.firePropertyChange("AddUser", null, "Petra")
        support.firePropertyChange(request.getType(), null, request.getArg());
      }
    }
    catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  @Override public void addUser(UserEntry user)
  {
    try
    {
      Socket socket = new Socket("localhost", 2910);
      ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
      outToServer.writeObject(new Request("AddUser", user));
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override public List<UserEntry> getUsers()
  {
    try
    {
      Request response = request("GetUsers");
      return (List<UserEntry>) response.getArg();
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public void addMessage(MessageEntry message)
  {
    try
    {
      Socket socket = new Socket("localhost", 2910);
      ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
      outToServer.writeObject(new Request("AddMessage", message));
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override public List<MessageEntry> getMessages()
  {
    try
    {
      Request response = request("GetMessages");
      return (List<MessageEntry>) response.getArg();
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  // To avoid repetitive, I extracted common code from getMessages and getUsers
  // And created this method - done automatically by highlighting the section and Ctrl+Alt+M
   private Request request(String type) throws IOException, ClassNotFoundException
  {
    Socket socket = new Socket("localhost", 2910);
    ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
    ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
    outToServer.writeObject(new Request(type, null));
    return (Request) inFromServer.readObject();
  }

  @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(eventName, listener);
  }
}
