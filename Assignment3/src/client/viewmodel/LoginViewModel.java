package client.viewmodel;

import client.model.DataModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.transferobjects.UserEntry;

public class LoginViewModel
{
    private StringProperty username, error;
    private DataModel model;

    public LoginViewModel(DataModel model) {
        this.model = model;
        username = new SimpleStringProperty();
        error = new SimpleStringProperty();
    }

    public void addUser() {
        String input = username.get();
        if(input != null && !"".equals(input)) {
            UserEntry newUser = new UserEntry(input);
            model.addUser(newUser);
            model.setUsername(input);
            error.set("Nickname saved. You can enter the chat.");
        } else {
            error.set("ERROR: Input cannot be empty");
        }
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public StringProperty errorProperty() {
        return error;
    }
}
