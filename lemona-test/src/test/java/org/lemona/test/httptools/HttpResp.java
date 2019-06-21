package org.lemona.test.httptools;

import java.util.HashMap;
import java.util.Map;

public class HttpResp {
    Map<String, String> headers = new HashMap<>();

    public HttpResp(){
    }

    public HttpResp(int statusCode, String response){
        this.statusCode = statusCode;
        this.response = response;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCod) {
        this.statusCode = statusCod;
    }

    int statusCode;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    String response;
}
