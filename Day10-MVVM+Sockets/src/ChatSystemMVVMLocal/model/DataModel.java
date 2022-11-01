package ChatSystemMVVMLocal.model;

import ChatSystemMVVMLocal.util.Subject;

import java.util.List;

public interface DataModel extends Subject {

    void addUser(String user);
    List<UserEntry> getUsers();
    void addMessage(String message);
    List<String> getMessages();

}


