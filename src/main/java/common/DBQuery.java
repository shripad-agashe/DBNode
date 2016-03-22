package common;

public class DBQuery {

    static final long serialVersionUID = 1L;
    private  String key = "";

    public DBQuery(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public DBQuery(){}
}
