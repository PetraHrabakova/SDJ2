package ToUppercaseSockets.client.model;

import ToUppercaseSockets.shared.transferobjects.LogEntry;
import ToUppercaseSockets.shared.util.Subject;

import java.util.List;

public interface TextConverter extends Subject {

    String toUppercase(String text);
    List<LogEntry> getLogs();

}


