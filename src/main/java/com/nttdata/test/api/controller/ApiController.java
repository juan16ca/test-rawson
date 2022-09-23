package com.nttdata.test.api.controller;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.test.api.exceptions.TipoDocumentoInvalidoException;
import com.nttdata.test.api.model.entity.User;
import com.nttdata.test.api.service.IUserService;

@RestController
public class ApiController {

    private static final Logger logger = LogManager.getLogger(ApiController.class);

    @Autowired
    private IUserService userService;

    @CrossOrigin
    @GetMapping("/{tipoDocumento}/{numeroDocumento}")
    public ResponseEntity<User> getInformationUser(@PathVariable String tipoDocumento,
            @PathVariable String numeroDocumento) throws TipoDocumentoInvalidoException {

        logger.info("tipoDocumento: {}", tipoDocumento);
        logger.info("numeroDocumento: {}", numeroDocumento);

        if (!tipoDocumento.equals("C") && !tipoDocumento.equals("P")) {
            throw new TipoDocumentoInvalidoException("Invalido tipo de documento, debe ser C o P");
        }

        if (numeroDocumento.equals("1")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        Optional<User> userOptional = userService.getInformationUser(tipoDocumento, numeroDocumento);
        if (!userOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(userOptional.get());
    }

}
