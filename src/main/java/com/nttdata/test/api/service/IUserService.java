package com.nttdata.test.api.service;

import java.util.Optional;

import com.nttdata.test.api.model.entity.User;

public interface IUserService {

    public Optional<User> getInformationUser(String tipoDocumento, String numeroDocumento);
    
}
