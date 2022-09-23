package com.nttdata.test.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class TipoDocumentoInvalidoException extends Exception {

    public TipoDocumentoInvalidoException(String message) {
        super(message);
    }

}
