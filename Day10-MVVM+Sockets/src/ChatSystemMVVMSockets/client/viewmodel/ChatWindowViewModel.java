package ChatSystemMVVMSockets.client.viewmodel;

import ChatSystemMVVMSockets.shared.transferobjects.MessageEntry;
import ChatSystemMVVMSockets.client.model.DataModel;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.util.List;

public class ChatWindowViewModel
{
    private DataModel model;
    private StringProperty message;
    private ObservableList<MessageEntry> messages;
    private String username;

    public ChatWindowViewModel(DataModel model) {
        this.model = model;
        username = model.getUsername();
        message = new SimpleStringProperty(username + "> ");
        model.addListener("NewMessageEntry", this::onNewMessageEntry);
    }

    private void onNewMessageEntry(PropertyChangeEvent event) {
        Platform.runLater(() -> {
            messages.add((MessageEntry) event.getNewValue());
        });
    }

    public void loadMessages() {
        List<MessageEntry> messageList = model.getMessages();
        messages = FXCollections.observableArrayList(messageList);
    }

    public ObservableList<MessageEntry> getMessages() {
        return messages;
    }

    public StringProperty messageProperty() {
        return message;
    }

    public String getMessageIdentificator() {
        return model.getUsername() + "> ";
    }


    public void addMessage() {
        MessageEntry input = new MessageEntry(message.getValue());

        if(!(input.getMessage().equals(getMessageIdentificator() + ""))) {
            model.addMessage(input);
        } else {
            message.setValue("ERROR: Input cannot be empty");
        }
    }
}
