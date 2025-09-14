package pt.ulusofona.cd.brand.repository;

import java.util.UUID;

public interface Identifiable {
    UUID getId();
    void setId(UUID id);
}