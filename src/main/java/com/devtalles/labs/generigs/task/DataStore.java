package com.devtalles.labs.generigs.task;

import java.util.*;

public class DataStore<T, K> {

    private final List<T> dataList;
    private final Map<K, T> dataMap;

    public DataStore() {
        this.dataList = new ArrayList<>();
        this.dataMap = new HashMap<>();
    }

    public boolean add(K key, T item) throws NullPointerException {
        Objects.requireNonNull(key, "The key is requeried");
        Objects.requireNonNull(item, "The item is requeried");

        if (dataMap.containsKey(key)) {
            return false;
        }

        dataList.add(item);
        dataMap.put(key, item);

        return true;
    }

    public T remove(K key) {
        Objects.requireNonNull(key, "The key is requeried");
        if (!dataMap.containsKey(key)) {
            throw new RuntimeException("The key does not exist");
        }

        T data = dataMap.get(key);
        dataList.remove(data);
        dataMap.remove(key);

        return data;
    }

     public T find(K key) {
         Objects.requireNonNull(key, "The key is requeried");
        if (!dataMap.containsKey(key)) {
            throw new RuntimeException("The key doesn't exist");
        }

        T data = dataMap.get(key);

        return data;
     }

     public List<T> getAll() {
        return Collections.unmodifiableList(dataList);
     }



}
