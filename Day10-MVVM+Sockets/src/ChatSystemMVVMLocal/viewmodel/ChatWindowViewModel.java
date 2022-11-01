package ChatSystemMVVMLocal.viewmodel;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import ChatSystemMVVMLocal.model.DataModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class ChatWindowViewModel implements PropertyChangeListener
{
    private DataModel model;
    private StringProperty message;
    private ObservableList<String> messages;


    public ChatWindowViewModel(DataModel model) {
        this.model = model;
        message = new SimpleStringProperty();
        model.addListener(this::propertyChange);

    }

    public void loadMessages() {
        List<String> messageList = model.getMessages();
        messages = FXCollections.observableArrayList(messageList);
    }

    public ObservableList<String> getMessages() {
        return messages;
    }

    public StringProperty messageProperty() {
        return message;
    }


    public void addMessage() {
        String input = message.getValue();
        if(input != null && !"".equals(input)) {
            model.addMessage(input);
        } else {
            message.setValue("ERROR: Input cannot be empty");
        }
    }

    @Override public void propertyChange(PropertyChangeEvent event)
    {
        Platform.runLater(() -> {
            if (String.valueOf(event.getPropertyName()).equals("MessageAdded")){
                loadMessages();
            }
        });
    }
}
