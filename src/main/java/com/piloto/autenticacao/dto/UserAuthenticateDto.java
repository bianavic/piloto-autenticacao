package com.piloto.autenticacao.dto;

import com.piloto.autenticacao.model.User;
import lombok.Getter;

// modificar o retorno no controller
// usamos DTO para nao trafegar os usuarios de dominios da aplicacao entre as requisicoes
// por isso criamos essas classes q criam objetos temporarios para transitar de um lado para o outro
@Getter
public class UserAuthenticateDto {
  private String type;
  private String cpf;
  private String token;

  public UserAuthenticateDto(String cpf, String token, String type) {
    this.cpf = cpf;
    this.token = token;
  }

  public UserAuthenticateDto() {}

  // metodo para transformar 1 usuario em 1 dto
  public static UserAuthenticateDto toDto(User user, String type) {
    return new UserAuthenticateDto(user.getCpf(), user.getToken(), type);
  }

}
