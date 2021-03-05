package com.piloto.autenticacao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "oauth_access_token")
public class OauthAccessToken {

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
    private String username;

    @Getter
    @Setter
    @Column(name="client_id")
    private String clientId;

    @Getter
    @Setter
    @Lob
    @Column(name="authentication", columnDefinition = "mediumblob")
    private byte[] authentication;

    @Getter
    @Setter
    @Column(name="refresh_token")
    private String refreshToken;

}
