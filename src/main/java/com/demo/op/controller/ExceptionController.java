package com.demo.op.controller;

import com.demo.op.model.EmptyResponseDTO;
import com.demo.op.model.RegistroResponseDTO;
import com.demo.op.model.ResponseDetailDTO;
import com.demo.op.util.exception.CampoInvalidoException;
import com.demo.op.util.exception.NoAutorizadoException;
import com.demo.op.util.exception.NoEncontradoException;
import com.demo.op.util.exception.RequestInvalidoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = NoAutorizadoException.class)
    public ResponseEntity<EmptyResponseDTO> exception(NoAutorizadoException exception) {
        return new ResponseEntity<>(new EmptyResponseDTO()
                .message(exception.getMessage()).type("Error"), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = NoEncontradoException.class)
    public ResponseEntity<EmptyResponseDTO> exception(NoEncontradoException exception) {
        return new ResponseEntity<>(new EmptyResponseDTO()
                .message(exception.getMessage()).type("Error"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = RequestInvalidoException.class)
    public ResponseEntity<EmptyResponseDTO> exception(RequestInvalidoException exception) {
        return new ResponseEntity<>(new EmptyResponseDTO()
                .message(exception.getMessage()).type("Error"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = CampoInvalidoException.class)
    public ResponseEntity<RegistroResponseDTO> exception(CampoInvalidoException exception) {
        List<ResponseDetailDTO> messages = new ArrayList<>();
        messages.add(new ResponseDetailDTO()
                .field(exception.field())
                .message(exception.message()));

        return new ResponseEntity<>(new RegistroResponseDTO()
                .message(exception.getMessage()).type("Error")
                .messages(messages), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<EmptyResponseDTO> exception(RuntimeException exception) {
        return new ResponseEntity<>(new EmptyResponseDTO()
                .message("Error Interno").type("Error"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
