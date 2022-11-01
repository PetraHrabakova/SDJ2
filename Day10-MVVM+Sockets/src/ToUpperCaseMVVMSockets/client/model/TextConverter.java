package ToUpperCaseMVVMSockets.client.model;

import ToUpperCaseMVVMSockets.shared.transferobjects.LogEntry;
import ToUpperCaseMVVMSockets.shared.util.Subject;

import java.util.List;

public interface TextConverter extends Subject {

    String toUppercase(String text);
    List<LogEntry> getLogs();

}


