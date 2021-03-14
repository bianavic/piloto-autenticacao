package com.piloto.autenticacao.services;

import com.piloto.autenticacao.model.User;
import com.piloto.autenticacao.error.CpfExistsException;
import com.piloto.autenticacao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

    private UserRepository userRepository;
    private TokenService tokenService;

    @Autowired
    public UserRegistrationService(UserRepository userRepository, TokenService tokenService) {
        this.userRepository = userRepository;
        this.tokenService = tokenService;
    }

    public User registrate(User user) {
        user.setToken(tokenService.generateToken(user));
        return userRepository.save(user);
    }
}
