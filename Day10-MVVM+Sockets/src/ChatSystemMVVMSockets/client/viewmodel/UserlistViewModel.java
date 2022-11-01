package ChatSystemMVVMSockets.client.viewmodel;

import ChatSystemMVVMSockets.client.model.DataModel;
import ChatSystemMVVMSockets.shared.transferobjects.UserEntry;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class UserlistViewModel
{

    private ObservableList<UserEntry> users;

    private DataModel model;

    public UserlistViewModel(DataModel model) {
        this.model = model;
        model.addListener("NewUserEntry", this::onNewUserEntry);
    }

    private void onNewUserEntry(PropertyChangeEvent event) {
        users.add((UserEntry) event.getNewValue());
    }

    public void loadUsers() {
        List<UserEntry> userList = model.getUsers();
        users = FXCollections.observableArrayList(userList);
    }

    public ObservableList<UserEntry> getUsers() {
        return users;
    }

}
