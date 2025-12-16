package com.devtalles.labs.taskOptional.service;

import com.devtalles.labs.taskOptional.exceptions.InvalidProductException;
import com.devtalles.labs.taskOptional.model.Product;
import com.devtalles.labs.taskOptional.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() throws InvalidProductException {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }


    public void saveProduct(Product product) throws InvalidProductException {
        ProductValidator.validate(product);
        if (!productRepository.existById(product.getId())) {
            productRepository.save(product);
            System.out.println("Product saved......");
        } else {
            throw new InvalidProductException("The product already exist!");
        }

    }

    public void deleteProduct(Long id) throws InvalidProductException{
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.delete(id);
            System.out.println("Product was deleted");
        } else {
            throw new InvalidProductException("The product does not exist!");
        }
    }

    public void updateProduct(Product product) throws InvalidProductException {
        ProductValidator.validate(product);
        Optional<Product> findProduct = productRepository.findById(product.getId());
        if (findProduct.isPresent()) {
            productRepository.update(Optional.of(product));
            System.out.println("Updating product completed....");
        } else {
            throw new InvalidProductException("The product does not exist!");
        }
    }


}
