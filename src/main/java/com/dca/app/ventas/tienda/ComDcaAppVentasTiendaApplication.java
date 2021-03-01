package com.dca.app.ventas.tienda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EntityScan({"com.dca.app.ventas.tienda", "com.dca.crud.tienda.commons.models.entity"})
@EnableFeignClients
public class ComDcaAppVentasTiendaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComDcaAppVentasTiendaApplication.class, args);
    }

}
