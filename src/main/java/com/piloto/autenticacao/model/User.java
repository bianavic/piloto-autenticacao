package com.piloto.autenticacao.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.io.Serializable;

@Getter
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @CPF
    @NotNull(message = "These fields are required")
    private String cpf;

    @NotNull(message = "These fields are required")
    @Size(min = 8, message = "Try one with at least 8 characters")
    private String password;

}
