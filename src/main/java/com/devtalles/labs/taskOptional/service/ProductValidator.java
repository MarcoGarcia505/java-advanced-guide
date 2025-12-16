package com.devtalles.labs.taskOptional.service;

import com.devtalles.labs.taskOptional.exceptions.InvalidProductException;
import com.devtalles.labs.taskOptional.model.Product;

public class ProductValidator {
    public static void validate(Product product) throws InvalidProductException{
        if (product.getPrice() <= 0) {
            throw new InvalidProductException("the cost can not be less that 0");
        }
        if (product.getStock() < 0) {
            throw new InvalidProductException("the stock can not be less that 0");
        }
    }
}
