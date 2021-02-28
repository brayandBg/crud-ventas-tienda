package com.dca.app.ventas.tienda.models.dao;

import com.dca.crud.tienda.commons.models.entity.Venta;
import org.springframework.data.repository.CrudRepository;

public interface IVentaDAO extends CrudRepository<Venta, Long> {
}
