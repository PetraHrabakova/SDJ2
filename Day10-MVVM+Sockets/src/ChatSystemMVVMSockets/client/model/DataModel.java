package ChatSystemMVVMSockets.client.model;

import ChatSystemMVVMSockets.shared.transferobjects.MessageEntry;
import ChatSystemMVVMSockets.shared.transferobjects.UserEntry;
import ChatSystemMVVMSockets.shared.util.Subject;

import java.util.List;

public interface DataModel extends Subject
{
    void addUser(String user);
    List<UserEntry> getUsers();
    void addMessage(MessageEntry message);
    List<MessageEntry> getMessages();
    String getUsername();
    void setUsername(String username);
}


