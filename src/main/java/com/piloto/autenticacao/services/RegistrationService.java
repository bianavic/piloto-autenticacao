package com.piloto.autenticacao.services;

import com.piloto.autenticacao.dto.UserDto;
import com.piloto.autenticacao.model.User;
import com.piloto.autenticacao.error.CpfExistsException;
import com.piloto.autenticacao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class RegistrationService {

    @Autowired
    UserRepository repository;

    public void insert(User user) {

        User registeredUser = repository.findByCpf(user.getCpf());

        if (registeredUser == null) repository.save(user);

        else throw new CpfExistsException("User is already registered");

        /**
        if (registeredUser == null){
            repository.save(user);
        }
        else {
            throw new CpfExistsException(User is already registered");
        }
         **/
    }
}
