package com.asj.examen.examenbackend.exceptions.vendedor;

public class VendedorYaExisteException extends Exception{

    public VendedorYaExisteException() {
    }

    public VendedorYaExisteException(String message) {
        super(message);
    }

    public VendedorYaExisteException(String message, Throwable cause) {
        super(message, cause);
    }

    public VendedorYaExisteException(Throwable cause) {
        super(cause);
    }

    public VendedorYaExisteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
