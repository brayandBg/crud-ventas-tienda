package com.dca.app.ventas.tienda.exception.exceptions;

public class MasterResourceNotFoundException extends Exception {

    public static final String DESCRIPCION = "Registro no encontrado";

    public MasterResourceNotFoundException() {
        super(DESCRIPCION);
    }

    public MasterResourceNotFoundException(String message) {
        super(DESCRIPCION + ": " + message);
    }
}
