package com.piloto.autenticacao.services;

import com.piloto.autenticacao.model.User;
import com.piloto.autenticacao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    UserRepository repository;

    public User save(User user){

        User registeredUser = repository.findByCpf(user.getCpf());

        if (registeredUser == null){
            repository.save(user);
            System.out.println("OK, CADASTRADO");
        }
        else if (registeredUser.getCpf().equals(user.getCpf())){
            System.out.println("CPF ALREADY EXIST");
        }
        return registeredUser;
    }
}
