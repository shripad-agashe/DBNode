package common;

import java.io.Serializable;

public class DBEntry implements Serializable{
    static final long serialVersionUID = 1L;
    public  String key ="";
    public  String value ="";

    public DBEntry(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public DBEntry(){

    }
}
