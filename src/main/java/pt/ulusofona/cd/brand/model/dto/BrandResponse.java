package pt.ulusofona.cd.brand.model.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
public class BrandResponse {
    private UUID id;
    private String name;
}