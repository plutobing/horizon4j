package com.gome.cloud.horizon4j.exceptions;

/**
 * Created by pluto on 6/6/16.
 */
public class TableInitializedException extends RuntimeException {

    public TableInitializedException(String message, Exception e) {
        super(message, e);
    }

}
