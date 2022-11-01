package ToUpperCaseMVVMSockets.client.network;

import ToUpperCaseMVVMSockets.shared.transferobjects.LogEntry;
import ToUpperCaseMVVMSockets.shared.util.Subject;

import java.util.List;

public interface Client extends Subject {

    String toUppercase(String str);
    List<LogEntry> getLog();

    void startClient();
}
