package com.piloto.autenticacao.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginUserDatas {

  private String cpf;
  private String password;

  public LoginUserDatas(String cpf, String password) {
    this.cpf = cpf;
    this.password = password;
  }

}
