package com.sriram.catService.domain;

public class ProductNotFoundException extends RuntimeException
{
    public ProductNotFoundException(String message)
    {
        super(message);
    }

    public static ProductNotFoundException forCode(final String code)
    {
        return new ProductNotFoundException("Product with code " + code + " not found");
    }
}
