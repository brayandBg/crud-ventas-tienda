package com.dca.app.ventas.tienda.client;


import com.dca.crud.tienda.commons.models.entity.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "crud-tienda",url = "localhost:8090/producto")
public interface IProductoClient {

    @GetMapping(value = "/buscar/{id}")
    public Producto findById(@PathVariable Long id);

    @PutMapping(value = "/edit/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto edit(@RequestBody Producto p, @PathVariable Long id);

}
