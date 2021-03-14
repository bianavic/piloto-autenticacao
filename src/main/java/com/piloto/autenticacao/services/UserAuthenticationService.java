package com.piloto.autenticacao.services;

import com.piloto.autenticacao.dto.LoginUserDatas;
import com.piloto.autenticacao.exception.ExistingCpfException;
import com.piloto.autenticacao.exception.ExpiredTokenException;
import com.piloto.autenticacao.exception.InvalidLoginException;
import com.piloto.autenticacao.exception.InvalidTokenException;
import com.piloto.autenticacao.model.User;
import com.piloto.autenticacao.repository.UserRepository;
import io.jsonwebtoken.Claims;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthenticationService {

  private final UserRepository userRepository;
  private final TokenService tokenService;

  @Autowired
  public UserAuthenticationService(UserRepository userRepository, TokenService tokenService) {
    this.userRepository = userRepository;
    this.tokenService = tokenService;
  }

  public User authenticate(LoginUserDatas loginUserDatas, String token) {
    User user = userRepository.findByCpf(loginUserDatas.getCpf()).orElseThrow(ExistingCpfException::new);
    if (loginUserDatas.getPassword().equals(user.getPassword()) && !token.isEmpty() && validate(token)) {
      return user;
    } else {
      throw new InvalidLoginException();
    }
  }

  private boolean validate(String token) {
    try {
      String tokenTratado = token.replace("Bearer ", "");
      Claims claims = tokenService.decodeToken(tokenTratado);

      System.out.println(claims.getIssuer());
      System.out.println(claims.getIssuedAt());

      // verifica se o token esta expirado
      if (claims.getExpiration().before(new Date(System.currentTimeMillis()))) throw new ExpiredTokenException();
      System.out.println(claims.getExpiration());
      return true;
    } catch (ExpiredTokenException expiredTokenException) {
      expiredTokenException.printStackTrace();
      throw expiredTokenException;
    } catch (Exception exception) {
      exception.printStackTrace();
      throw new InvalidTokenException();
    }
  }
}
