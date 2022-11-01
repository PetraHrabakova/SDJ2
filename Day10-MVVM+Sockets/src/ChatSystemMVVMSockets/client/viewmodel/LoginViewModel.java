package ChatSystemMVVMSockets.client.viewmodel;

import ChatSystemMVVMSockets.client.model.DataModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

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
            model.addUser(input);
            model.setUsername(username.get());
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
