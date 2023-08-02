package br.com.projetoconest.api.resource;

import br.com.projetoconest.api.model.entities.User;
import br.com.projetoconest.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<User> getUser(){
        return ResponseEntity.status(200).body(userService.getAuthenticatedUser());
    }

}
