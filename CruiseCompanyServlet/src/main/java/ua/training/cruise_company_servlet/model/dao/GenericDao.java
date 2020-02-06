package ua.training.cruise_company_servlet.model.dao;

import java.util.List;

public interface GenericDao<T>{
    boolean create (T entity);
    T findById(int id);
    List<T> findAll();
    void update(T entity);
    void delete(int id);
}
