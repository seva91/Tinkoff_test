package com.example.slepnev.tinkoff.network.exceptions;

/**
 * Created by slepnev on 12.03.16.
 */
public class InteractionException extends Exception {

    private String code;

    public InteractionException(String mCode) {
        this.code = mCode;
    }

    public String getCode() {
        return code;
    }
}
