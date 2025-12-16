package com.devtalles.labs.taskOptional.repository;

import com.devtalles.labs.taskOptional.exceptions.InvalidProductException;
import com.devtalles.labs.taskOptional.interfaces.ProductRepositoryInterface;
import com.devtalles.labs.taskOptional.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepository implements ProductRepositoryInterface {

    private List<Product> products = new ArrayList<>();


    @Override
    public List<Product> findAll() throws InvalidProductException {
        if (this.products.isEmpty()) throw new InvalidProductException("The list is empty");
        return this.products;
    }

    @Override
    public Optional<Product> findById(Long id) {
        Optional<Product> findProduct = products.stream().filter(item -> item.getId().equals(id)).findFirst();
        return findProduct;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public void delete(Long id) {
        products.removeIf(item -> item.getId().equals(id));
    }

    @Override
    public void update(Optional<Product> product) throws InvalidProductException{
        if (product.isPresent()) {
            Long productId = product.get().getId();
            int validId = findIndexById(productId);
            if (validId != -1) {
                products.set(validId, product.get());
            } else {
                throw new InvalidProductException("The product does not exist");
            }
        } else {
            throw new InvalidProductException("Please send a valid product");
        }
    }

    @Override
    public boolean existById(Long id) {
        return products.stream().anyMatch(item -> item.getId().equals(id));
    }


    private int findIndexById(Long id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
