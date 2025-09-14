package pt.ulusofona.cd.brand.controller;

import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import pt.ulusofona.cd.brand.mapper.BrandMapper;
import pt.ulusofona.cd.brand.model.Brand;
import pt.ulusofona.cd.brand.model.dto.BrandRequest;
import pt.ulusofona.cd.brand.model.dto.BrandResponse;
import pt.ulusofona.cd.brand.service.BrandService;
import java.util.*;

@RestController
@RequestMapping("/api/v1/brands")
public class BrandController {

    private final BrandService service;

    public BrandController(BrandService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<BrandResponse> create(
            @Valid @RequestBody BrandRequest request
    ) {
        Brand created = service.createBrand(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(BrandMapper.toResponse(created));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrandResponse> getById(@PathVariable UUID id) {
        Brand brand = service.getBrandById(id);
        return ResponseEntity.ok(BrandMapper.toResponse(brand));
    }

    @GetMapping
    public ResponseEntity<List<BrandResponse>> getAll() {
        List<Brand> brands = service.getAllBrands();
        List<BrandResponse> responseList = brands.stream()
                .map(BrandMapper::toResponse)
                .toList();

        return ResponseEntity.ok(responseList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BrandResponse> update(
            @PathVariable UUID id,
            @Valid @RequestBody BrandRequest request
    ) {
        Brand updated = service.updateBrand(id, request);
        return ResponseEntity.ok(BrandMapper.toResponse(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.deletebrand(id);
        return ResponseEntity.noContent().build();
    }
}