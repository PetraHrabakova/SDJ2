package ToUpperCaseMVVMSockets.server.model;


import ToUpperCaseMVVMSockets.shared.transferobjects.LogEntry;
import ToUpperCaseMVVMSockets.shared.util.Subject;

import java.util.List;

public interface TextManager extends Subject {

    String toUppercase(String str);
    List<LogEntry> getLog();
}
