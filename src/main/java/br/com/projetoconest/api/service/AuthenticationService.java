package br.com.projetoconest.api.service;

import br.com.projetoconest.api.model.dto.request.SignInRequest;
import br.com.projetoconest.api.model.dto.request.SignUpRequest;
import br.com.projetoconest.api.model.dto.response.JwtAuthenticationResponse;
import br.com.projetoconest.api.model.entities.User;
import br.com.projetoconest.api.model.enums.Role;
import br.com.projetoconest.api.repository.UserRepository;
import br.com.projetoconest.api.utils.UtilService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UtilService utilService;

    public JwtAuthenticationResponse signup(SignUpRequest request) {
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .nickname(request.getNickname())
                .active(true)
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER).build();
        if(!utilService.canUserRegister(request)){
            throw new IllegalArgumentException("User already exists");
        }
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    public JwtAuthenticationResponse signin(SignInRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

}
