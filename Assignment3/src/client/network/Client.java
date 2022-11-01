package client.network;

import shared.transferobjects.MessageEntry;
import shared.transferobjects.UserEntry;
import shared.util.Subject;

import java.util.List;

public interface Client extends Subject
{
  void addUser(UserEntry user);
  List<UserEntry> getUsers();
  void addMessage(MessageEntry message);
  List<MessageEntry> getMessages();
  void startClient();
}
