package br.com.projetoconest.api.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;
import org.hibernate.validator.constraints.br.CNPJ;

@Value
public class OngRequest {
    @NotBlank
    String name;
    @NotBlank
    String description;
    @NotBlank
    String tourLink;
    @NotBlank
    String category;
    String cnpj;
}
