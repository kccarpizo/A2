
package com.example.restapiassign2;

import java.util.List;

/**
 *
 * @author kimberlycarpizo
 */
public class CustomResponse<T> {
    private String message;
    private List<T> body;
    
    
    public CustomResponse(){
    
    }

    public CustomResponse(String message, List<T> body) {
        this.message = message;
        this.body = body;
    }

    public CustomResponse(String message) {
        this.message = message;
    }
    

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getbMessage() {
        return body;
    }

    public void setbMessage(List<T> body) {
        this.body = body;
    }

    
    
    
}
