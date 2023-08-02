package br.com.projetoconest.api.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class OngRequest {
    @NotBlank
    String name;
    @NotBlank
    String description;
    @NotBlank
    String tourLink;
    String category;
}
