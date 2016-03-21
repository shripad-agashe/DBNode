package common;

import java.io.Serializable;

public class DBOperationResponse implements Serializable{
    static final long serialVersionUID = 1L;
    private String response;

    public String getResponse() {
        return response;
    }

    public DBOperationResponse(String response) {
        this.response = response;
    }
}
