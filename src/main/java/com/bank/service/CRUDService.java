package com.bank.service;

import java.util.List;

public interface CRUDService <T,ID>{
    T findById(int id);
    List<T> findAll();
    T update(T entity);
    T save(T entity);
    String delete(int id);

}
