package com.sriram.catService.domain;

class ProductMapper
{
    static Product toProduct(final ProductEntity entity)
    {
        return new Product(entity.getCode(),
                entity.getName(),
                entity.getDescription(),
                entity.getImageUrl(),
                entity.getPrice());
    }
}
