package pt.ulusofona.cd.brand.model;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import pt.ulusofona.cd.brand.repository.Identifiable;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public class Brand implements Identifiable {
    private UUID id;

    @NotBlank
    @Size(min = 1, max = 120)
    private String name;

    private Instant createdAt;
    private Instant updatedAt;
}