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

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Getter
    @Setter
    @CPF
    @NotNull(message = "These field are required")
    private String cpf;

    @Getter @Setter
    @NotNull(message = "These field are required")
    @Size(min = 8, message = "Try one with at least 8 characters")
    private String password;

    public User() {
    }

    public User(String cpf, String password, Integer id) {
        this.cpf = cpf;
        this.password = password;
        this.id = id;
    }
}
