package org.lemona.test.httptools;

public class ConnectionException extends Exception {
    public ConnectionException(String message) {
        super(message);
    }

    public ConnectionException(String message, Throwable e) {
        super(message, e);
    }
}
