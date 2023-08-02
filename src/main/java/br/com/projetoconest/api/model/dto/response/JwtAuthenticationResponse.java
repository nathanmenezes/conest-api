package br.com.projetoconest.api.model.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JwtAuthenticationResponse {

    private String token;
}
