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
@RequestMapping("/api/v1/ong")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
@CrossOrigin("http://localhost:4200")
public class OngResource {

    private final OngService ongService;

    @PostMapping
    public ResponseEntity<MessageResponse> saveOng(@RequestBody OngRequest request) {
        return ongService.saveOng(request);
    }

    @PutMapping("/images/{id}")
    public ResponseEntity<MessageResponse> updateOng(@PathVariable Long id, @RequestParam(required = false, name = "profilePicture") MultipartFile profilePicture, @RequestParam(required = false, name = "bannerPicture") MultipartFile bannerPicture) throws IOException {
        return ongService.updateOngImages(id, profilePicture, bannerPicture);
    }

    @GetMapping("/images/{name}")
    public ResponseEntity<byte[]> getOngImages(@PathVariable String name) {
        return ongService.getImage(name);
    }

}
