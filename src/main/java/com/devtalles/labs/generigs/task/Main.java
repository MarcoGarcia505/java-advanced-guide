package com.devtalles.labs.generigs.task;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataStore<User, String> userStore = new DataStore<>();

        try {
            userStore.add("123", new User("123", "Pedro"));
            userStore.add("333", new User("333", "Juan"));
            userStore.add("444", new User("444", "Ramiro"));
            userStore.add("555", new User("555", "Axel"));
            userStore.add("666", new User("666", "Noe"));
            userStore.add(null, new User("432", "Mario"));

            System.out.println("Deleted: " + userStore.remove("123"));
            System.out.println("User found ->" + userStore.find("666"));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        List<User> users = userStore.getAll();

        for (User dataUser: users){
            System.out.println(dataUser.toString());
        }

    }
}
