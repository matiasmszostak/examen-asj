package com.asj.examen.examenbackend.exceptions;

public class ProductoYaExisteExcpetion extends Exception{

    public ProductoYaExisteExcpetion() {
    }

    public ProductoYaExisteExcpetion(String message) {
        super(message);
    }

    public ProductoYaExisteExcpetion(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductoYaExisteExcpetion(Throwable cause) {
        super(cause);
    }

    public ProductoYaExisteExcpetion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
