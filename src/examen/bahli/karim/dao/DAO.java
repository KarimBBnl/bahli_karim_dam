package examen.bahli.karim.dao;

import java.util.List;

public interface DAO<T> {
    void add(T entity);
    void update(T entity);
    T findById(int id);
    List<T> findAll();

}
