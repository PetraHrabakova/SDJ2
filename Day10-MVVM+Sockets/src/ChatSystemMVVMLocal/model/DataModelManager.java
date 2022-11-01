package ChatSystemMVVMLocal.model;

import ChatSystemMVVMLocal.util.Subject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class DataModelManager implements DataModel, Subject
{

    private List<UserEntry> users = new ArrayList<>();
    private List <MessageEntry> messages = new ArrayList<>();
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void addUser(String user) {
        UserEntry newUser = new UserEntry(user);
        users.add(newUser);
        support.firePropertyChange("UserAdded", null, newUser);
    }

    @Override
    public List<UserEntry> getUsers() {
        return users;
    }

    @Override public void addMessage(String message)
    {
        MessageEntry newMessage = new MessageEntry(message);
        messages.add(newMessage);
        support.firePropertyChange("MessageAdded", null, newMessage);
    }

    @Override public List<String> getMessages() {
        List<String> stringMessages = new ArrayList<>();
        for (MessageEntry message: messages) {
            stringMessages.add(message.message());
        }
        return stringMessages; }

    @Override
    public void addListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void removeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}


