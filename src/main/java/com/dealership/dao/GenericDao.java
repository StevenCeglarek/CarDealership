package com.dealership.dao;

import com.dealership.util.DealershipCollection;

public interface GenericDao<T, I> {

    int add(T t);

    T findById(I i);

    boolean remove(I i);

    boolean update(T t);

    DealershipCollection<T> findAll();
}