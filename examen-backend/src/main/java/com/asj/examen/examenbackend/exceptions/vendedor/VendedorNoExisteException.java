package com.asj.examen.examenbackend.exceptions.vendedor;

public class VendedorNoExisteException extends Exception{

    public VendedorNoExisteException() {
    }

    public VendedorNoExisteException(String message) {
        super(message);
    }

    public VendedorNoExisteException(String message, Throwable cause) {
        super(message, cause);
    }

    public VendedorNoExisteException(Throwable cause) {
        super(cause);
    }

    public VendedorNoExisteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
