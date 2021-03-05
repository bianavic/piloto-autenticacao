package com.piloto.autenticacao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "oauth_client_details")
public class OauthClientDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "ID", columnDefinition = "bigint unsigned")
    private Integer id;

    @Getter
    @Setter
    @Column(name="client_id")
    private String clientId;

    @Getter
    @Setter
    @Column(name="client_name")
    private String clientName;

    @Getter
    @Setter
    @Column(name="resource_ids")
    private String resourceIds;

    @Getter
    @Setter
    @Column(name="client_secret")
    private String clientSecret;

    @Getter
    @Setter
    @Column(name="scope")
    private String scope;

    @Getter
    @Setter
    @Column(name="authorized_grant_types")
    private String authorizedGrantTypes;

    @Getter
    @Setter
    @Column(name="web_server_redirect_uri")
    private String webServerRedirectUri;

    @Getter
    @Setter
    @Column(name="authorities")
    private String authorities;

    @Getter
    @Setter
    @Column(name="access_token_validity", length=11)
    private Integer accessTokenValidity;

    @Getter
    @Setter
    @Column(name="refresh_token_validity", length=11)
    private Integer refreshTokenValidity;

    @Getter
    @Setter
    @Column(name="additional_information", length=4096)
    private String additionalInformation;

    @Getter
    @Setter
    @Column(name="autoapprove", columnDefinition = "TINYINT(4)")
    private Integer autoapprove;

    @Getter
    @Setter
    @Column(name="uuid")
    private String uuid;

    @Getter
    @Setter
    @Column
    private Date created;

    @Getter
    @Setter
    @Column(columnDefinition ="boolean default true")
    private Boolean enabled;

    @Getter
    @Setter
    @Transient
    private String[] scopes;

    @Getter
    @Setter
    @Transient
    private String[] grantTypes;

    @Getter
    @Setter
    @Transient
    private String ownerEmail;
}
