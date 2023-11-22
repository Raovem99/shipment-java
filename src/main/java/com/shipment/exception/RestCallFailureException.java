package com.shipment.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RestCallFailureException extends RuntimeException {

    private ErrorMessage errorMessage;

    public RestCallFailureException() {
        super();
    }

    public RestCallFailureException(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }

    public RestCallFailureException(ErrorMessage errorMessage, String message) {
        super(message);
        this.errorMessage = errorMessage;
    }


}
