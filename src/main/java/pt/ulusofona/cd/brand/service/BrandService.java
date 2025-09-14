package pt.ulusofona.cd.brand.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pt.ulusofona.cd.brand.exception.BrandNotFoundException;
import pt.ulusofona.cd.brand.mapper.BrandMapper;
import pt.ulusofona.cd.brand.model.Brand;
import pt.ulusofona.cd.brand.model.dto.BrandRequest;
import pt.ulusofona.cd.brand.repository.BrandRepository;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository repo;

    public Brand createBrand(BrandRequest request) {
        Brand brand = BrandMapper.toEntity(request);

        brand.setId(UUID.randomUUID());
        brand.setCreatedAt(Instant.now());
        brand.setUpdatedAt(Instant.now());

        return repo.save(brand);
    }

    public Brand getBrandById(UUID id) {
        return repo.findById(id)
                .orElseThrow(() -> new BrandNotFoundException(id));
    }

    public List<Brand> getAllBrands() {
        return repo.findAll();
    }

    public Brand updateBrand(UUID id, BrandRequest request) {
        Brand existing = getBrandById(id);

        existing.setName(request.getName().trim());
        existing.setUpdatedAt(Instant.now());

        return repo.save(existing);
    }

    public void deletebrand(UUID id) {
        if (!repo.findById(id).isPresent()) {
            throw new BrandNotFoundException(id);
        }
        repo.deleteById(id);
    }
}