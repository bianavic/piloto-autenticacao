package com.piloto.autenticacao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="oauth_client_token")
public class OauthClientToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "ID", columnDefinition = "bigint unsigned")
    private Integer id;

    @Getter
    @Setter
    @Column(name="token_id")
    private String tokenId;

    @Getter
    @Setter
    @Lob
    @Column(name="token", columnDefinition = "mediumblob")
    private byte[] token;

    @Getter
    @Setter
    @Column(name="authentication_id")
    private String authenticationId;

    @Getter
    @Setter
    @Column(name="user_name")
    private String userName;

    @Getter
    @Setter
    @Column(name="client_id")
    private String clientId;
}
