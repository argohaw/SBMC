package com.sriram.catService.domain;

import com.sriram.catService.ApplicationProperties;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService
{

    private final ProductRepository productRepository;
    private final ApplicationProperties properties;

    ProductService(ProductRepository productRepository,
                   ApplicationProperties properties)
    {
        this.productRepository = productRepository;
        this.properties = properties;
    }

    public PagedResult<Product> getProducts(int pageNo)
    {
        Sort sort = Sort.by("name").ascending();
        pageNo = pageNo <= 1 ? 0 : pageNo - 1;
        Pageable pageable = PageRequest.of(pageNo, properties.pageSize(), sort);
        Page<Product> productPage = productRepository.findAll(pageable).map(
                ProductMapper::toProduct);

        return new PagedResult<>(productPage.getContent(),
                productPage.getTotalElements(),
                productPage.getNumber() + 1,
                productPage.getTotalPages(),
                productPage.isFirst(),
                productPage.isLast(),
                productPage.hasNext(),
                productPage.hasPrevious());

    }

    public Optional<Product> getProductByCode(String code)
    {
        return productRepository.findByCode(code).map(ProductMapper::toProduct);
    }
}
