package client.model;

import client.network.Client;
import shared.transferobjects.MessageEntry;
import shared.transferobjects.UserEntry;
import shared.util.Subject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class DataModelManager implements DataModel, Subject
{
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private Client client;
    private String username;

    public DataModelManager(Client client) {
        this.client = client;
        client.startClient();
        client.addListener("NewUserEntry", this::onNewUserEntry);
        client.addListener("NewMessageEntry", this::onNewMessageEntry);
    }

    // The following 2 methods are listening to the Client property changes and
    // Fire another property change which is handled in the view models
    private void onNewUserEntry(PropertyChangeEvent event) {
        support.firePropertyChange(event);
    }

    private void onNewMessageEntry(PropertyChangeEvent event) {
        support.firePropertyChange(event);
    }

    @Override
    public void addUser(UserEntry user) {
        client.addUser(user);
    }

    @Override
    public List<UserEntry> getUsers() {
        return client.getUsers();
    }

    @Override public void addMessage(MessageEntry message) { client.addMessage(message);
    }

    @Override public List<MessageEntry> getMessages() {
        return client.getMessages();
    }

    @Override
    public void addListener(String event, PropertyChangeListener listener) {
        support.addPropertyChangeListener(event, listener);
    }

    @Override
    public void removeListener(String event, PropertyChangeListener listener) {
        support.removePropertyChangeListener(event, listener);
    }

    @Override
    public String getUsername() { return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }


}


