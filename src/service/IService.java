package service;

import java.util.List;

public interface IService<T> {
    void add(T object);

    void update(Long id, T newObject);

    void delete(Long id);

    T findById(Long id);

    List<T> findByName(String name);

    List<T> findAll();

}