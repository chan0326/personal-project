package com.erichgamma.api.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Box<T>{
    private Map<String ,T>box;

    public Box() {
        this.box = new HashMap<>();
    }
    public T put(String key, T t) {
        return box.put(key, t);
    }

    public  void put(List<String> key , Inventory<T> values){
        box = new HashMap<>();
        for (int i=0;i<key.size();i++){
            box.put(key.get(i), values.get(i));

        }
        box.forEach((k,v)-> System.out.println(k+" "+v));
    }
    public T get(String key) {

        return box.get(key);
    }
    public void clear() {

        box.clear();
    }
    public int size() {
        return box.size();
    }



}

