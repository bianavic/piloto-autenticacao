package com.piloto.autenticacao.controller;

import com.piloto.autenticacao.dto.UserDto;
import com.piloto.autenticacao.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping(value = "/login", produces = {"application/json"})
    public ResponseEntity<String> login(@Valid @RequestBody UserDto userDto) {

        loginService.login(userDto);

        return ResponseEntity.ok().body("You have successfully logged in");
    }

}
