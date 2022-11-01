package ChatSystemMVVMSockets.server.model;

import ChatSystemMVVMSockets.shared.transferobjects.MessageEntry;
import ChatSystemMVVMSockets.shared.transferobjects.UserEntry;
import ChatSystemMVVMSockets.shared.util.Subject;

import java.util.List;

public interface DataModel extends Subject
{
  void addUser(UserEntry user);
  List<UserEntry> getUsers();
  void addMessage(MessageEntry message);
  List<MessageEntry> getMessages();
}
