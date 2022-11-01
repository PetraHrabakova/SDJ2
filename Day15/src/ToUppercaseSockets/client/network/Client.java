package ToUppercaseSockets.client.network;

import ToUppercaseSockets.shared.transferobjects.LogEntry;
import ToUppercaseSockets.shared.util.Subject;

import java.util.List;

public interface Client extends Subject {

    String toUppercase(String str);
    List<LogEntry> getLog();

    void startClient();
}
