package com.piloto.autenticacao.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="user", uniqueConstraints = @UniqueConstraint(columnNames = {"userName"}, name="USER_UNIQUE_USERNAME"))
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "ID", columnDefinition = "bigint unsigned")
    private Integer id;

    @Getter
    @Setter
    @Column(length=50)
    private String userName;

    @Getter
    @Setter
    @CPF
    @NotNull(message = "These fields are required")
    private String cpf;

    @Getter @Setter
    @NotNull(message = "These field are required")
    @Size(min = 8, message = "Try one with at least 8 characters")
    private String password;

    @Getter
    @Setter
    @Column
    private Boolean accountExpired;

    @Getter
    @Setter
    @Column
    private Boolean accountLocked;

    @Getter
    @Setter
    @Column
    private Boolean credentialsExpired;

    @Getter
    @Setter
    @Column
    private Boolean enabled;

    @Getter
    @Setter
    @OneToMany(mappedBy = "user", targetEntity = UserAuthority.class, cascade = {
            CascadeType.ALL }, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<UserAuthority> userAuthorities = new HashSet<UserAuthority>();


    public User() {
    }

    public User(String cpf, String password, Integer id) {
        this.cpf = cpf;
        this.password = password;
        this.id = id;
    }
}
