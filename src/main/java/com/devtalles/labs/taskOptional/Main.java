package com.devtalles.labs.taskOptional;

import com.devtalles.labs.taskOptional.controller.ProductController;
import com.devtalles.labs.taskOptional.repository.ProductRepository;
import com.devtalles.labs.taskOptional.service.ProductService;
import com.devtalles.labs.taskOptional.view.ProductView;

public class Main {
    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository();
        ProductService productService = new ProductService(productRepository);
        ProductController productController = new ProductController(productService);

        ProductView productView = new ProductView(productController);

        productView.showMenu();
    }
}
