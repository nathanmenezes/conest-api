package br.com.projetoconest.api.service;

import br.com.projetoconest.api.model.dto.request.OngRequest;
import br.com.projetoconest.api.model.dto.response.MessageResponse;
import br.com.projetoconest.api.model.entities.Ong;
import br.com.projetoconest.api.repository.OngRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class OngService {

    private final OngRepository ongRepository;
    private final UserService userService;

    public ResponseEntity<MessageResponse> saveOng(OngRequest request){
        Ong ong = ongRepository.save(Ong.builder()
                .user(userService.getAuthenticatedUser())
                .name(request.getName())
                .description(request.getDescription())
                .tourLink(request.getTourLink())
                .category(request.getCategory())
                .build());
        return ResponseEntity.ok(MessageResponse.builder()
                .message("ONG cadastrada com sucesso!")
                .body(ong)
                .build());
    }
}
