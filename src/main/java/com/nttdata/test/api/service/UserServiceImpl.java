package com.nttdata.test.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.test.api.model.entity.User;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private User user;

    @Override
    public Optional<User> getInformationUser(String tipoDocumento, String numeroDocumento) {

        Optional<User> userOptional = Optional.empty();

        if (numeroDocumento.equals("23445322")) {

            user = new User(tipoDocumento, numeroDocumento, "Juan", "Carlos", "Parra", "Arias", "7777777",
                    "Calle falsa # 123", "Bogota");

            userOptional = Optional.of(user);
        }

        return userOptional;
    }

}
