package com.piloto.autenticacao.controller;

import com.piloto.autenticacao.dto.UserDto;
import com.piloto.autenticacao.model.User;
import com.piloto.autenticacao.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService service;

    @PostMapping(value = "/registration", produces = {"application/json"})
    public String registration(@Valid @RequestBody User user){

        service.insert(user);

        return "User registered successfully";
    }
    
}
