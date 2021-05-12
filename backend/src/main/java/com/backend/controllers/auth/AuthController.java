package com.backend.controllers.auth;

import com.backend.configs.jwt.JwtProvider;
import com.backend.models.User;
import com.backend.repositories.IUserRepository;
import com.backend.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthController {
    private final UserService userService;
    private final JwtProvider jwtProvider;
    private final IUserRepository userRepository;


    public AuthController(UserService userService, JwtProvider jwtProvider, IUserRepository userRepository) {
        this.userService = userService;
        this.jwtProvider = jwtProvider;
        this.userRepository = userRepository;
    }

    @PostMapping("login")
    public ResponseEntity<AuthResponse> login(@Valid AuthRequest authRequest) {
        User user = userService.getUserByEmailAndPassword(authRequest.getEmail(), authRequest.getPassword());
        String token = jwtProvider.generateToken(user.getEmail());
        return ResponseEntity.ok(new AuthResponse().build(token, user));
    }

    @PostMapping("registration")
    public ResponseEntity<ResponseMessage> registration(@Valid RegistrationRequest registrationRequest) {
        if (userRepository.existsUserByEmail(registrationRequest.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseMessage("User with this emails exists"));
        }
        userService.saveUser(registrationRequest);
        return ResponseEntity.ok(new ResponseMessage("You are successfully registered!"));
    }
}
