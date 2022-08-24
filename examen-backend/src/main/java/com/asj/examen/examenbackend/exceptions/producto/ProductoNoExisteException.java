package com.asj.examen.examenbackend.exceptions.producto;

public class ProductoNoExisteException extends Exception{
    public ProductoNoExisteException() {
    }

    public ProductoNoExisteException(String message) {
        super(message);
    }

    public ProductoNoExisteException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductoNoExisteException(Throwable cause) {
        super(cause);
    }

    public ProductoNoExisteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
