package org.lemona.test.httptools;

public class ResponseException extends Exception {
    int code;
    public ResponseException(int code, String message, Throwable e) {
        super(message, e);
        this.code = code;
    }

    public ResponseException(String message, Throwable e) {
        super(message, e);
    }
}
