package eCallServer.beans;

import java.io.Serializable;

public class User implements Serializable
{
    private String count;
    private String password;
    private String type;

    public User(String count, String password, String type)
    {
        this.count = count;
        this.password = password;
        this.type = type;
    }

    public void setCount(String count)
    {
        this.count = count;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public String getCount()
    {
        return count;
    }
    public String getPassword()
    {
        return password;
    }
    public String getType()
    {
        return type;
    }

    public String toString()
    {
        return "User [count=" + count + ", type=" + type + "]";
    }
}