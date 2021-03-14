package com.piloto.autenticacao.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.piloto.autenticacao.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonAutoDetect(fieldVisibility =  Visibility.ANY)
public class UserRegistrationDto  extends User {

  private Integer id;

  private String cpf;
  private String password;

  public UserRegistrationDto() { }

  public UserRegistrationDto(String cpf, String password) {
    this.cpf = cpf;
    this.password = password;
  }

  public User toUser() {
    return new User(getCpf(), getPassword());
  }

}
