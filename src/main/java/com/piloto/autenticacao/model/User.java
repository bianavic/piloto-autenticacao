package com.piloto.autenticacao.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Getter
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @CPF
    @NotNull(message = "These fields are required")
    @Column(name = "cpf")
    private String cpf;

    @NotNull(message = "These fields are required")
    @Size(min = 8, message = "Try one with at least 8 characters")
    @Column(name = "password")
    private String password;

}
