package ChatSystemMVVMSockets.shared.transferobjects;

import java.io.Serializable;

public class MessageEntry implements Serializable
{
  private String message;

  public MessageEntry(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public String toString() { return message; }

}
