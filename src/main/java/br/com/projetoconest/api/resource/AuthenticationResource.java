package br.com.projetoconest.api.resource;

import br.com.projetoconest.api.model.dto.request.SignInRequest;
import br.com.projetoconest.api.model.dto.request.SignUpRequest;
import br.com.projetoconest.api.model.dto.response.JwtAuthenticationResponse;
import br.com.projetoconest.api.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationResource {
    private final AuthenticationService authenticationService;

    @PostMapping("/signin")
    public DeferredResult<ResponseEntity<JwtAuthenticationResponse>> signIn(@RequestBody @Valid SignInRequest signInRequest) {
        final DeferredResult<ResponseEntity<JwtAuthenticationResponse>> deferredResult = new DeferredResult<>();
        deferredResult.setResult(ResponseEntity.ok().body(authenticationService.signin(signInRequest)));
        return deferredResult;
    }

    @PostMapping("/signup")
    public DeferredResult<ResponseEntity<JwtAuthenticationResponse>> signUp(@RequestBody @Valid SignUpRequest signUpRequest) {
        final DeferredResult<ResponseEntity<JwtAuthenticationResponse>> deferredResult = new DeferredResult<>();
        deferredResult.setResult(ResponseEntity.ok().body(authenticationService.signup(signUpRequest)));
        return deferredResult;
    }


}
