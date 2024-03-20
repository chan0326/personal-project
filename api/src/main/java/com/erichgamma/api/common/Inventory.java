package com.erichgamma.api.common;

import java.util.ArrayList;

public class Inventory<T> {

    private ArrayList<T> arrayList;

    public Inventory() {
        this.arrayList = new ArrayList<>();
    }

    public void add(T t){
        arrayList.add(t);
    }

    public T remove(int i){
        return arrayList.remove(i);
    }
    public boolean contains(T t) {

//        return arrayList.indexOf(t) >= 0;
        return arrayList.contains(t);

    }
    public T get(int i) {
        return arrayList.get(i);
    }
    public void clear() {
        arrayList.clear();
    }
}

