package com.asj.examen.examenbackend.exceptions.venta;

public class VentaNoExisteException extends Exception{
    public VentaNoExisteException() {
    }

    public VentaNoExisteException(String message) {
        super(message);
    }

    public VentaNoExisteException(String message, Throwable cause) {
        super(message, cause);
    }

    public VentaNoExisteException(Throwable cause) {
        super(cause);
    }

    public VentaNoExisteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
