package com.dca.app.ventas.tienda.exception;


import com.dca.app.ventas.tienda.exception.exceptions.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({MasterResourceNotFoundException.class})
    @ResponseBody
    public ApiException notFoundRequestException(HttpServletRequest request, Exception e) {
        HttpStatus notFound = HttpStatus.NOT_FOUND;

        ApiException apiException = new ApiException(
                e.getMessage(),
                notFound,
                ZonedDateTime.now(ZoneId.of("Z")),
                request.getRequestURI()
        );

        return apiException;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({Exception.class, MasterResourceFieldAlreadyExistException.class,
            MethodArgumentNotValidException.class,
            DataIntegrityViolationException.class, UnexpectedRollbackException.class,
            ApiRequestException.class,  MasterResourceDeletedException.class})
    @ResponseBody
    public ApiException badRequestException(HttpServletRequest request, Exception e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        ApiException apiException = new ApiException(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z")),
                request.getRequestURI()
        );

        return apiException;
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public ApiException forbiddenRequestException(HttpServletRequest request, Exception e) {
        HttpStatus forbidden = HttpStatus.FORBIDDEN;

        ApiException apiException = new ApiException(
                e.getMessage(),
                forbidden,
                ZonedDateTime.now(ZoneId.of("Z")),
                request.getRequestURI()
        );

        return apiException;
    }


}
