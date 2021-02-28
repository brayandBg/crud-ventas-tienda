package com.dca.app.ventas.tienda.documentacion;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class DocumentacionApi {
    @Bean
    public Docket api() {
        final Docket build = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(queryApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dca.app.ventas.tienda"))
                .paths(PathSelectors.any())
                .build()
                .tags(new Tag("Ventas de tienda", "Esta API es un complemento de API crud-tienda para ventas")
                );
        return build;
    }

    public ApiInfo queryApiInfo() {
        return new ApiInfoBuilder()
                .title("VENTA TIENDA")
                .description("Venta de productos de tienda")
                .version("1.0.0")
                .license("VENTAS TIENDA License Version 1.0")
                .licenseUrl("http://www.dcatech.com")
                .contact(new Contact("DCA Technology", "http://www.dcatech.com", "info@dcatech.com"))
                .build();
    }

}
