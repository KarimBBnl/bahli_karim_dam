package examen.bahli.karim.dao;

import java.util.ArrayList;

public interface DAO<T> {
    void add(T entity);
    void update(int id, T entity);
    void delete(int id);
    T find(int id);
    ArrayList<T> findAll();

}
