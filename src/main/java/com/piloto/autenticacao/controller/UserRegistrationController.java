package com.piloto.autenticacao.controller;

import com.piloto.autenticacao.dto.UserAuthenticateDto;
import com.piloto.autenticacao.dto.UserRegistrationDto;
import com.piloto.autenticacao.model.User;
import com.piloto.autenticacao.services.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserRegistrationController {

    private UserRegistrationService userRegistrationService;

    @Autowired
    public UserRegistrationController(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    public UserRegistrationController() {}

    @PostMapping("/user")
    public ResponseEntity<UserAuthenticateDto> registrate(@RequestBody UserRegistrationDto userRegistrationDto) {
        User user = userRegistrationService.registrate(userRegistrationDto.toUser());
        return new ResponseEntity<UserAuthenticateDto>(UserAuthenticateDto.toDto(user, "Bearer "),
            HttpStatus.CREATED);
    }
    
}
