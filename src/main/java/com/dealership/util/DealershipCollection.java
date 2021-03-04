package com.dealership.util;

public abstract class DealershipCollection<T> {

    /**
     * Optional size number for non expandable subclasses
     */
    protected int maxSize;

    public abstract T get(T c);

    public abstract T get(int i);

    public abstract void addCar(T t);

    public abstract void addUser(T t);

    public abstract int size();

    public abstract void removeUser(T t);

    public abstract void removeCar(T t);

//    public abstract String toString();

    abstract boolean isEmpty();

    protected abstract void clear();

}

