package ToUppercaseSockets.server.model;


import ToUppercaseSockets.shared.transferobjects.LogEntry;
import ToUppercaseSockets.shared.util.Subject;

import java.util.List;

public interface TextManager extends Subject {

    String toUppercase(String str);
    List<LogEntry> getLog();
}
