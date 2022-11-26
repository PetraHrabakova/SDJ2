package client.viewmodel;

import client.model.DataModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transferobjects.UserEntry;

import java.beans.PropertyChangeEvent;
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
