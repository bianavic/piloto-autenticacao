package com.piloto.autenticacao.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.piloto.autenticacao.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class UserResponserDto {

  private Integer id;

  private String cpf;
  private String password;

  public UserResponserDto(){}

  public UserResponserDto(String cpf, String password) {
    this.cpf = cpf;
    this.password = password;
  }

  public static UserResponserDto toDto(User user) {
    return new UserResponserDto(user.getCpf(), user.getPassword());
  }

}
