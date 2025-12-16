package com.devtalles.labs.taskOptional.interfaces;

import com.devtalles.labs.taskOptional.exceptions.InvalidProductException;
import com.devtalles.labs.taskOptional.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryInterface {
    List<Product> findAll() throws Exception;
    Optional<Product> findById(Long id);
    void save(Product product);
    void delete(Long id);
    void update(Optional<Product> product) throws InvalidProductException;
    boolean existById(Long id);
}
