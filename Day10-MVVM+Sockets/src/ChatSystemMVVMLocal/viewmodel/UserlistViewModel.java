package ChatSystemMVVMLocal.viewmodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ChatSystemMVVMLocal.model.UserEntry;
import ChatSystemMVVMLocal.model.DataModel;

import java.util.List;

public class UserlistViewModel
{

    private ObservableList<UserEntry> users;

    private DataModel model;

    public UserlistViewModel(DataModel model) {
        this.model = model;
    }

    public void loadUsers() {
        List<UserEntry> userList = model.getUsers();
        users = FXCollections.observableArrayList(userList);
    }

    public ObservableList<UserEntry> getUsers() {
        return users;
    }
}
