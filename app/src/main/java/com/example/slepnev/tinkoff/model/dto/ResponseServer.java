package com.example.slepnev.tinkoff.model.dto;

/**
 * Created by slepnev on 12.03.16.
 */
public class ResponseServer<ResultType> {

    private String resultCode;

    private ResultType payload;

    public String getResultCode() {
        return resultCode;
    }

    public ResultType getPayload() {
        return payload;
    }
}
