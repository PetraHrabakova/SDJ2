package ChatSystemMVVMSockets.client.network;

import ChatSystemMVVMSockets.shared.transferobjects.MessageEntry;
import ChatSystemMVVMSockets.shared.transferobjects.UserEntry;
import ToUpperCaseMVVMSockets.shared.util.Subject;

import java.util.List;

public interface Client extends Subject
{
  void addUser(String user);
  List<UserEntry> getUsers();
  void addMessage(MessageEntry message);
  List<MessageEntry> getMessages();
  void startClient();
}
