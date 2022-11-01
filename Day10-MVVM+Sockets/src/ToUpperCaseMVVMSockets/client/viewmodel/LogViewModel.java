package ToUpperCaseMVVMSockets.client.viewmodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ToUpperCaseMVVMSockets.shared.transferobjects.LogEntry;
import ToUpperCaseMVVMSockets.client.model.TextConverter;

import java.beans.PropertyChangeEvent;
import java.util.List;

public class LogViewModel {

    private ObservableList<LogEntry> logs;

    private TextConverter textConverter;

    public LogViewModel(TextConverter textConverter) {
        this.textConverter = textConverter;
        textConverter.addListener("NewLogEntry", this::onNewLogEntry);
    }

    private void onNewLogEntry(PropertyChangeEvent evt) {
        logs.add((LogEntry)evt.getNewValue());
    }

    public void loadLogs() {
        List<LogEntry> logList = textConverter.getLogs();
        logs = FXCollections.observableArrayList(logList);
    }

    public ObservableList<LogEntry> getLogs() {
        return logs;
    }
}
