package com.dca.app.ventas.tienda.models.services;

import com.dca.app.ventas.tienda.exception.exceptions.MasterResourceDeletedException;
import com.dca.app.ventas.tienda.exception.exceptions.MasterResourceFieldAlreadyExistException;
import com.dca.app.ventas.tienda.exception.exceptions.MasterResourceNotFoundException;
import com.dca.crud.tienda.commons.models.entity.Venta;

import java.util.List;

public interface IVentaService {
    public List<Venta> findAll();

    public Venta findById(long id) throws MasterResourceNotFoundException;

    public Venta save (Venta v) throws MasterResourceFieldAlreadyExistException, MasterResourceNotFoundException;

    public void del (Long id) throws MasterResourceDeletedException;
}
