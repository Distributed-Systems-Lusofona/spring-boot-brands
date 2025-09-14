package pt.ulusofona.cd.brand.mapper;

import pt.ulusofona.cd.brand.model.Brand;
import pt.ulusofona.cd.brand.model.dto.BrandRequest;
import pt.ulusofona.cd.brand.model.dto.BrandResponse;

public class BrandMapper {

    public static Brand toEntity(BrandRequest dto) {
        Brand b = new Brand();
        b.setName(dto.getName().trim());
        return b;
    }

    public static BrandResponse toResponse(Brand entity) {
        BrandResponse r = new BrandResponse();
        r.setId(entity.getId());
        r.setName(entity.getName());
        return r;
    }
}