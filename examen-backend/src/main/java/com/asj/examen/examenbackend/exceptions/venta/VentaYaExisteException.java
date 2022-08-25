package com.asj.examen.examenbackend.exceptions.venta;

public class VentaYaExisteException extends Exception{
    public VentaYaExisteException() {
    }

    public VentaYaExisteException(String message) {
        super(message);
    }

    public VentaYaExisteException(String message, Throwable cause) {
        super(message, cause);
    }

    public VentaYaExisteException(Throwable cause) {
        super(cause);
    }

    public VentaYaExisteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
