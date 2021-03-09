package com.piloto.autenticacao.dto;

import com.piloto.autenticacao.model.User;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserDto implements Serializable {

    private String cpf;
    private String password;

}
