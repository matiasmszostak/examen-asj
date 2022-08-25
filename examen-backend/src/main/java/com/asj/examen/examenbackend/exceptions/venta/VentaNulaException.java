package com.asj.examen.examenbackend.exceptions.venta;

public class VentaNulaException extends Exception{

    public VentaNulaException() {
    }

    public VentaNulaException(String message) {
        super(message);
    }

    public VentaNulaException(String message, Throwable cause) {
        super(message, cause);
    }

    public VentaNulaException(Throwable cause) {
        super(cause);
    }

    public VentaNulaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
