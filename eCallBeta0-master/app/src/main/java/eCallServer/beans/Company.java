package eCallServer.beans;

import java.io.Serializable;

public class Company implements Serializable
{
    private String count;
    private String name;
    private String type;
    private String scale;
    private String disc;

    public Company(String name, String type, String scale, String disc)
    {
        this.name = name;
        this.type = type;
        this.scale = scale;
        this.disc = disc;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getScale() {
        return scale;
    }
    public void setScale(String scale) {
        this.scale = scale;
    }
    public String getDisc() {
        return disc;
    }
    public void setDisc(String disc) {
        this.disc = disc;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }


}