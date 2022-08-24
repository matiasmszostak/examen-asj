package com.asj.examen.examenbackend.exceptions.producto;

public class ProductoNuloException extends Exception{


    public ProductoNuloException() {
    }

    public ProductoNuloException(String message) {
        super(message);
    }

    public ProductoNuloException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductoNuloException(Throwable cause) {
        super(cause);
    }

    public ProductoNuloException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
