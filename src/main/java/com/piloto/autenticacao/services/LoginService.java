package com.piloto.autenticacao.services;

import com.piloto.autenticacao.dto.UserDto;
import com.piloto.autenticacao.model.User;
import com.piloto.autenticacao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {

    @Autowired
    UserRepository repository;

    public User login(UserDto userDto) {

        User user = repository.findByCpf(userDto.getCpf());

        if (user.getPassword().equals(userDto.getPassword()))
            System.out.println("LOGGED!");
        else
            System.out.println("INVALID PASSWORD");
        return user;
    }
}