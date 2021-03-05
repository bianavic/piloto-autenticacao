package com.piloto.autenticacao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="oauth_code")
public class OauthCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "ID", columnDefinition = "bigint unsigned")
    private Integer id;

    @Getter
    @Setter
    @Column(name="code")
    private String code;

    @Getter
    @Setter
    @Lob
    @Column(name="authentication", columnDefinition = "mediumblob")
    private byte[] authentication;
}
