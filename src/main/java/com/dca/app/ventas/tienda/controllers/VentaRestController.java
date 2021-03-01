package com.dca.app.ventas.tienda.controllers;


import com.dca.app.ventas.tienda.client.IProductoClient;
import com.dca.app.ventas.tienda.exception.exceptions.MasterResourceDeletedException;
import com.dca.app.ventas.tienda.exception.exceptions.MasterResourceFieldAlreadyExistException;
import com.dca.app.ventas.tienda.exception.exceptions.MasterResourceNotFoundException;
import com.dca.app.ventas.tienda.models.services.IVentaService;
import com.dca.crud.tienda.commons.models.entity.Venta;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VentaRestController{

    @Autowired
    private IVentaService sendSer;


    @GetMapping("/listar")
    @ApiOperation(value = "Retorna lista de Ventas", notes = "<br>Retorna una lista con todas las Venta registradas en la BD"
            , response = Venta.class, responseContainer = "List", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Venta.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    public List <Venta> findAll(){
        return sendSer.findAll();

    }

    @GetMapping("/buscar/{id}")
    @ApiOperation(value = "Retorna una Venta", notes = "<br>Retorna una Venta atraves del ID"
            , response = Venta.class, responseContainer = "Venta", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Venta.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    public Venta findById(@PathVariable Long id) throws MasterResourceNotFoundException {
        return sendSer.findById(id);
    }

    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Actualiza la informacion de una Venta", notes = "<br>Actualiza la informacion de una Venta atraves del ID"
            , response = Venta.class, responseContainer = "Venta", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Venta.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    public Venta edit(@RequestBody Venta v, @PathVariable Long id) throws MasterResourceNotFoundException, MasterResourceFieldAlreadyExistException {
        Venta sond = sendSer.findById(id);
        sond.setId(v.getId());


        return sendSer.save(sond);
    }

    @PostMapping("/crea")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Crea una Venta", notes = "<br>Crea una Venta recibiendo un objeto Venta"
            , response = Venta.class, responseContainer = "Venta", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Venta.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    public Venta save(@RequestBody Venta v) throws MasterResourceFieldAlreadyExistException, MasterResourceNotFoundException {
        return sendSer.save(v);
    }

    @DeleteMapping("/del/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Elimina una Venta", notes = "<br>Elimina una Venta atraves del ID"
            , response = Venta.class, responseContainer = "null", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Venta.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    public void del(@PathVariable Long id) throws MasterResourceDeletedException {
        sendSer.del(id);
    }

}
