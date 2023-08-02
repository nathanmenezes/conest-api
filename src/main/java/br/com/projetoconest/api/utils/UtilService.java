package br.com.projetoconest.api.utils;

import br.com.projetoconest.api.model.dto.request.SignUpRequest;
import br.com.projetoconest.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UtilService {

    private final UserRepository userRepository;

    public Boolean canUserRegister(SignUpRequest request){
        if(userRepository.findByEmail(request.getEmail()).isPresent()){
            return false;
        }
        return userRepository.findByNickname(request.getNickname()).isEmpty();
    }
}
