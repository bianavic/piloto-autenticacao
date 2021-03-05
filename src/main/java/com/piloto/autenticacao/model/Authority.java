package com.piloto.autenticacao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "authority", uniqueConstraints = @UniqueConstraint(columnNames = {"name"}, name = "AUTHORITY_UNIQUE_NAME"))
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "ID", columnDefinition = "bigint unsigned")
    private Integer id;

    @Getter
    @Setter
    @Column(length = 20)
    private String name;
}
