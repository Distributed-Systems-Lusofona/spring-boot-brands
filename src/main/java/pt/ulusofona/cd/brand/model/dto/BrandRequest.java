package pt.ulusofona.cd.brand.model.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrandRequest {
    @NotBlank
    @Size(min = 1, max = 120)
    private String name;
}