package com.asj.examen.examenbackend.exceptions.vendedor;

public class VendedorNuloException extends Exception{

    public VendedorNuloException() {
    }

    public VendedorNuloException(String message) {
        super(message);
    }

    public VendedorNuloException(String message, Throwable cause) {
        super(message, cause);
    }

    public VendedorNuloException(Throwable cause) {
        super(cause);
    }

    public VendedorNuloException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
