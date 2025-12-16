package com.devtalles.labs.taskOptional.controller;

import com.devtalles.labs.taskOptional.exceptions.InvalidProductException;
import com.devtalles.labs.taskOptional.model.Product;
import com.devtalles.labs.taskOptional.service.ProductService;
import com.devtalles.labs.taskOptional.utils.Validates;

import java.util.List;
import java.util.Optional;

public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }


    public void addProduct(Product product) throws InvalidProductException {
        Validates.validateObject(product, "Product cant be null");
        productService.saveProduct(product);
    }

    public void removeProduct(Long id) throws InvalidProductException{
        Validates.validateNumber(id, "The id cant be null");
        productService.deleteProduct(id);
    }

    public List<Product> getAllProducts() throws InvalidProductException{
        return productService.getAllProducts();
    }

    public Optional<Product> getProductById(Long id) throws InvalidProductException{
        Validates.validateNumber(id, "The id cant be null");
        return productService.getProductById(id);
    }

    public void updateProduct(Product product) throws InvalidProductException{
        Validates.validateObject(product, "Product cant be null");
        productService.updateProduct(product);
    }
}
