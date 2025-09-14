package pt.ulusofona.cd.brand.exception;

import java.util.UUID;

public class BrandNotFoundException extends RuntimeException {
    public BrandNotFoundException(UUID id) {
        super("Brand not found with id: " + id);
    }
}