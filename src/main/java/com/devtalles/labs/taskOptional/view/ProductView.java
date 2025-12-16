package com.devtalles.labs.taskOptional.view;

import com.devtalles.labs.taskOptional.controller.ProductController;
import com.devtalles.labs.taskOptional.exceptions.InvalidProductException;
import com.devtalles.labs.taskOptional.model.Product;
import com.devtalles.labs.taskOptional.model.ProductCategory;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ProductView {

    private final ProductController productController;
    private final Scanner scanner;

    public ProductView(ProductController productController) {
        this.productController = productController;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n Gestion de Productos");
            System.out.println("1.-Agregar Producto");
            System.out.println("2.-Mostrar Producto");
            System.out.println("3.-Buscar producto por ID");
            System.out.println("4.-Eliminar Producto por ID");
            System.out.println("5.-Modificar Producto por ID");
            System.out.println("6.-Salir");
            System.out.println("Selecciona una opcion: ");
            int option = scanner.nextInt();
            scanner.nextLine();


            switch (option) {
                case 1 -> addProduct();
                case 2 -> showAllProducts();
                case 3 -> findByIdProduct();
                case 4 -> deleteProduct();
                case 5 -> updateProduct();
                case 6 -> {
                    return;
                }
                default -> {
                    System.out.println("Opcion inconrecta, please select a correct option");
                }
            }
        }
    }

    private void addProduct(){
        try {
            Long id = readValidLong("Insert the id: ", 0);
            String name = readNotEmptyString("Insert the name of the product: ");
            double price = readValidDouble("Insert the price: ", 0);
            int stock = readValidInteger("Insert the stock: ", 1);
            String categoryString = readNotEmptyString("Insert the category of the product \n ELECTRONICOS, COMIDAS, LIBROS, OTROS: ");

            ProductCategory productCategory = ProductCategory.valueOf(categoryString.trim().toUpperCase());

            Product product = new Product();
            product.setId(id);
            product.setPrice(price);
            product.setStock(stock);
            product.setCategory(productCategory);
            product.setName(name);

            productController.addProduct(product);
            System.out.println("Product added completed");
        } catch (InvalidProductException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("The category does not exist");
            System.out.println("Error inesperado");
            e.printStackTrace();
        }
    }

    private void showAllProducts() {
        try {
            List<Product> products = productController.getAllProducts();
            products.forEach(item -> showProduct(item));
        } catch (InvalidProductException e) {
            System.out.println("Error: " + e.getMessage());
        };
    }

    private void findByIdProduct() {
        try {
            Long id = readValidLong("Insert the id: ", 0);
            Optional<Product> product = productController.getProductById(id);
            if (product.isPresent()) {
                showProduct(product.get());
            } else {
                System.out.println("the product does not exist");
            }
        } catch (InvalidProductException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void updateProduct() {
        try {
            Long id = readValidLong("Insert the id to update: ", 0);
            Optional<Product> product = productController.getProductById(id);
            if (product.isPresent()) {
                System.out.println("-- PRODUCT TO UPDATE --");
                showProduct(product.get());
                System.out.println("selsect the filed to update");
                System.out.println("1.-Name");
                System.out.println("2.-Price");
                System.out.println("3.-Stock");
                System.out.println("4.-Category");
                System.out.println("5.-All");
                System.out.println("6.-exit");
                int opc = scanner.nextInt();
                scanner.nextLine();

                switch (opc) {
                    case 1 -> product.get().setName(readNotEmptyString("Insert the name: "));
                    case 2 -> product.get().setPrice(readValidDouble("Insert the price: ", 0));
                    case 3 -> product.get().setStock(readValidInteger("Insert the stock: ", 0));
                    case 4 -> product.get().setCategory(ProductCategory.valueOf(readNotEmptyString("Insert the category: ").trim().toUpperCase()));
                    case 5 -> {
                        product.get().setName(readNotEmptyString("Insert the name: "));
                        product.get().setPrice(readValidDouble("Insert the price: ", 0));
                        product.get().setStock(readValidInteger("Insert the stock: ", 1));
                        product.get().setCategory(ProductCategory.valueOf(readNotEmptyString("Insert the category\n ELECTRONICOS, COMIDAS, LIBROS, OTROS: ").trim().toUpperCase()));
                    }
                    case 6 -> {
                        scanner.close();
                        return;
                    }
                }

                productController.updateProduct(product.get());
            } else {
                System.out.println("the product does not exist");
            }
        } catch (InvalidProductException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void deleteProduct() {
        try {
            Long id = readValidLong("Insert the id: ", 0);
            productController.removeProduct(id);
        } catch (InvalidProductException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void showProduct(Product product) {
        System.out.println(".::PRODUCT::.\n");
        System.out.println("id: " + product.getId());
        System.out.println("name: " + product.getName());
        System.out.println("price: " + product.getPrice());
        System.out.println("stock: " + product.getStock());
        System.out.println("category: " + product.getCategory());
        System.out.println("-------------------------------");
    }

    private String readNotEmptyString(String message) {
        String input;
        do {
            System.out.println(message);
            input = scanner.nextLine().trim();
            if (input.length() < 3) {
                System.out.println("The string cant be less that 3 character");
            }
        } while (input.length() < 3);

        return input;
    }
    private long readValidLong(String message, long min) {
        long number;
        do {
            System.out.println(message);
            String input = scanner.nextLine();
            try {
                number = Long.parseLong(input);
                if (number < min) {
                    System.out.println("The number can not be less that " + min);
                    continue; // go direct to the while
                }

                return number;
            } catch (NumberFormatException e) {
                System.out.println("the value has to be a number");
            }
        } while (true);
    }
    private int readValidInteger(String message, long min) {
        int number;
        do {
            System.out.println(message);
            String input = scanner.nextLine();
            try {
                number = Integer.parseInt(input);
                if (number < min) {
                    System.out.println("The number can not be less that " + min);
                    continue; // go direct to the while
                }

                return number;
            } catch (NumberFormatException e) {
                System.out.println("the value has to be a number");
            }
        } while (true);
    }
    private double readValidDouble(String message, long min) {
        double number;
        do {
            System.out.println(message);
            String input = scanner.nextLine();
            try {
                number = Double.parseDouble(input);
                if (number < min) {
                    System.out.println("The number can not be less that " + min);
                    continue; // go direct to the while
                }

                return number;
            } catch (NumberFormatException e) {
                System.out.println("the value has to be a number");
            }
        } while (true);
    }
}
