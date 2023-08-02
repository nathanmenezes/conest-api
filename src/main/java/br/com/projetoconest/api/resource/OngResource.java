package br.com.projetoconest.api.resource;

import br.com.projetoconest.api.model.dto.request.OngRequest;
import br.com.projetoconest.api.model.dto.response.MessageResponse;
import br.com.projetoconest.api.service.OngService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/ongs")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class OngResource {

    private final OngService ongService;

    @PostMapping
    public ResponseEntity<MessageResponse> saveOng(@RequestBody OngRequest request) throws IOException {
        return ongService.saveOng(request);
    }

}
