package com.edsonteles.Workshopmongo.Resources.Exception;

import com.edsonteles.Workshopmongo.Exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler{

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException objectNotFoundException, HttpServletRequest servletRequest){
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(System.currentTimeMillis(),httpStatus.value(),"Não Encontrado", objectNotFoundException.getMessage(),
                servletRequest.getRequestURI());

        return ResponseEntity.status(httpStatus).body(err);
    }
}
