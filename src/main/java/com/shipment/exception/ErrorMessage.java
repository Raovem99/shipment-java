package com.shipment.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorMessage {
    private int statusCode;
    private String message;

    public ErrorMessage(){}
    public ErrorMessage(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }



}
