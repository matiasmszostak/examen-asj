package com.asj.examen.examenbackend.exceptions.producto;

public class ProductoYaExisteException extends Exception{

    public ProductoYaExisteException() {
    }

    public ProductoYaExisteException(String message) {
        super(message);
    }

    public ProductoYaExisteException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductoYaExisteException(Throwable cause) {
        super(cause);
    }

    public ProductoYaExisteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
