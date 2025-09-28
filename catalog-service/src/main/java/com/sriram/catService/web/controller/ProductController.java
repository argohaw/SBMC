package com.sriram.catService.web.controller;

import com.sriram.catService.domain.PagedResult;
import com.sriram.catService.domain.Product;
import com.sriram.catService.domain.ProductNotFoundException;
import com.sriram.catService.domain.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
class ProductController
{

    private final ProductService productService;

    ProductController(ProductService productService)
    {
        this.productService = productService;
    }

    @GetMapping
    PagedResult<Product> getProducts(@RequestParam(name = "page", defaultValue = "1") int pageNo)
    {
        return productService.getProducts(pageNo);
    }

    @GetMapping("/{code}")
    ResponseEntity<Product> getProductByCode(@PathVariable String code)
    {
        return productService.getProductByCode(code).map(ResponseEntity::ok).orElseThrow(
                () -> ProductNotFoundException.forCode(code));
    }
}
