package shared.transferobjects;

import java.io.Serializable;

public class UserEntry implements Serializable
{
    private String username;

    public UserEntry(String username) {
        this.username = username;
    }

    public String getUsername()
    {
        return username;
    }

}
