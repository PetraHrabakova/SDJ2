package ChatSystemMVVMLocal.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import ChatSystemMVVMLocal.model.DataModel;

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
