package server.model;

import shared.transferobjects.MessageEntry;
import shared.transferobjects.UserEntry;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class DataModelImpl implements DataModel
{

  private PropertyChangeSupport support;
  private List<MessageEntry> messages;
  private List<UserEntry> users;

  public DataModelImpl() {
    support = new PropertyChangeSupport(this);
    messages = new ArrayList<>();
    users = new ArrayList<>();
  }

  @Override public void addUser(UserEntry user)
  {
    users.add(user);
    support.firePropertyChange("NewUserEntry", null, user);
  }

  @Override public List<UserEntry> getUsers() {
    return new ArrayList<>(users);
  }

  @Override public void addMessage(MessageEntry message)
  {
    messages.add(message);
    System.out.println(message.getMessage());
    support.firePropertyChange("NewMessageEntry", null, message);
    System.out.println("NewMessageEntry fired");
  }

  @Override public List<MessageEntry> getMessages()
  {
    return new ArrayList<>(messages);
  }

  @Override public void addListener(String event, PropertyChangeListener listener) {
    support.addPropertyChangeListener(event, listener);
  }

  @Override public void removeListener(String event, PropertyChangeListener listener) {
    support.removePropertyChangeListener(event, listener);
  }
}
