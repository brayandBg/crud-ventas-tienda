package com.dca.app.ventas.tienda.exception.exceptions;

public class MasterResourceFieldAlreadyExistException extends Exception {

    public static final String DESCRIPCION = "El recurso ya se encuentra registrado";

    public MasterResourceFieldAlreadyExistException() {
        super(DESCRIPCION);
    }

    public MasterResourceFieldAlreadyExistException(String message) {
        super(DESCRIPCION + ": " + message);
    }
}
