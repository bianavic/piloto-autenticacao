package com.piloto.autenticacao.services;

import com.piloto.autenticacao.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

  // 30 minutos
  private static final long expirationTime = 1800000;
  private String key = "String Aleatoria";
  private String tokenPrefix = "Bearer";
  private String headerString = "Authorization";
  private Object SignatureAlgorithm;

  public String generateToken(User user) {
    return Jwts.builder()
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setSubject("Teste Jwt Api")
        .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
        .signWith((io.jsonwebtoken.SignatureAlgorithm) SignatureAlgorithm, key)
        .compact();
  }

  public Claims decodeToken(String token) {
    return Jwts.parser()
        .setSigningKey(key)
        .parseClaimsJws(token)
        .getBody();

  }
}
