package com.piloto.autenticacao.controller;

import com.piloto.autenticacao.dto.LoginUserDatas;
import com.piloto.autenticacao.dto.UserAuthenticateDto;
import com.piloto.autenticacao.model.User;
import com.piloto.autenticacao.services.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

  private UserAuthenticationService userAuthenticationService;

  @Autowired
  public AuthenticationController(UserAuthenticationService userAuthenticationService) {
    this.userAuthenticationService = userAuthenticationService;
  }

  public AuthenticationController() {}

  @RequestMapping("/login")
  public ResponseEntity<UserAuthenticateDto> authenticate(@RequestBody LoginUserDatas loginUserDatas, @RequestHeader String Authorization) {
    User user = userAuthenticationService.authenticate(loginUserDatas, Authorization);
    return new ResponseEntity<UserAuthenticateDto>(UserAuthenticateDto.toDto(user, "Bearer "), HttpStatus.ACCEPTED);
  }

}
