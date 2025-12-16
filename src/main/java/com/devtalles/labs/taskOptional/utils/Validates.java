package com.devtalles.labs.taskOptional.utils;

import com.devtalles.labs.taskOptional.exceptions.InvalidProductException;

public class Validates {
    public static <T extends Number> void  validateNumber (T number, String message) throws InvalidProductException {
        if (number == null) {
            throw new InvalidProductException(message);
        }
    }

    public static <T> void validateObject(T obj, String message) throws InvalidProductException {
        if (obj == null){
            throw new InvalidProductException(message);
        }
    }

    public static void validText(String text, String message) throws InvalidProductException {
        if (text == null || text.isEmpty()){
            throw new InvalidProductException(message);
        }
    }
}
