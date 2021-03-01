package com.dca.app.ventas.tienda.models.services.implement;

import com.dca.app.ventas.tienda.client.IProductoClient;
import com.dca.app.ventas.tienda.exception.exceptions.MasterResourceDeletedException;
import com.dca.app.ventas.tienda.exception.exceptions.MasterResourceNotFoundException;
import com.dca.app.ventas.tienda.models.dao.IVentaDAO;
import com.dca.app.ventas.tienda.models.services.IVentaService;
import com.dca.crud.tienda.commons.models.entity.Venta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private IVentaDAO dao;

    @Autowired
    IProductoClient prodFeign;

    private Venta v;

    @Override
    public List<Venta> findAll() {
        return (List<Venta>) dao.findAll();
    }

    @Override
    public Venta findById(long id) throws MasterResourceNotFoundException {
        v = dao.findById(id).orElse(null);
        if (v == null){
            throw new MasterResourceNotFoundException();
        }
        return v;
    }

    @Override
    public Venta save(Venta v) {

        v.setPrecio(v.getCantProd()*prodFeign.findById(v.getIdProduct()).getPrecio());
        return dao.save(v);
    }

    @Override
    public void del(Long id) throws MasterResourceDeletedException {

        try {
            dao.deleteById(id);
        }catch (Exception e){
            throw new MasterResourceDeletedException(e.getLocalizedMessage());
        }
    }
}